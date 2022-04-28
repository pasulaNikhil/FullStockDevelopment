package com.medicare.controller;


import java.util.HashSet;
import java.util.Set;

import com.medicare.helper.UserAlreadyExistsException;
import com.medicare.helper.UserNotFoundException;
import com.medicare.model.Role;
import com.medicare.model.User;
import com.medicare.model.UserRole;
import com.medicare.repository.RoleRepository;
import com.medicare.services.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired 
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/")
    public User addUser(@RequestBody User user) throws Exception{
        Role role = this.roleRepository.findById(2).get();
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        Set<UserRole> roles = new HashSet<>();
        roles.add(userRole);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        this.userServiceImpl.creatUser(user, roles);
        return user;
    }


    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userServiceImpl.getUser(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        this.userServiceImpl.deleteUser(id);
    }
    
    @PutMapping("/")
    public User updateUser(@RequestBody User user){
      Role role = this.roleRepository.findById(2).get();
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        Set<UserRole> roles = new HashSet<>();
        roles.add(userRole);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
      return this.userServiceImpl.updateUser(user,roles);
    }
    

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Exception> notFoundException(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
         new UserNotFoundException("USER NOT FOUND")
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
    