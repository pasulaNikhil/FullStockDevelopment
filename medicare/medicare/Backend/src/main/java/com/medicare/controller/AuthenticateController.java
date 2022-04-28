package com.medicare.controller;

import java.security.Principal;

import com.medicare.configs.JwtUtil;
import com.medicare.helper.UserAlreadyExistsException;
import com.medicare.helper.UserNotFoundException;
import com.medicare.model.JwtRequest;
import com.medicare.model.JwtResponse;
import com.medicare.model.User;
import com.medicare.services.impl.UserDetailsServiceImpl;
import com.medicare.services.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
  
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        
        try {
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        } catch (UserNotFoundException e) {
              e.printStackTrace();
             throw new Exception("User not found");
        }
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token =  this.jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }


    private void authenticate(String username, String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
           throw new UserNotFoundException("User is disabled");
        }catch(BadCredentialsException e){
          throw new UserNotFoundException("Invalid credentials");
        }

    }

     @GetMapping("/current-user")
    public User getCurrentUser(Principal principal){
        return this.userServiceImpl.getUser(principal.getName());
    }
    
     @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Exception> notFoundException(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
         new UserNotFoundException("Invalid credentials: user not found")
        );
    }
     @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Exception> alreadyExistException(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
         new UserAlreadyExistsException("user with this username already exists")
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Exception> exception(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
         new Exception("something went wrong")
        );
    }


}
