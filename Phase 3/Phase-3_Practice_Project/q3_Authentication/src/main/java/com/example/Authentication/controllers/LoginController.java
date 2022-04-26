package com.example.Authentication.controllers;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Authentication.entities.User;
import com.example.Authentication.exceptions.UserNotFoundException;
import com.example.Authentication.services.UserService;


@Controller
public class LoginController {

	@Autowired
	UserService userService;
	Logger log = LoggerFactory.getLogger(LoginController.class);
	

    @GetMapping("/index")
    public String showGreeting(ModelMap map) {
        return "index";
    }


    @GetMapping("/loginform")
    public String showLogin(ModelMap map) {
        return "loginform";
    }

    @PostMapping("/loginform") 
    public String submitLogin(ModelMap map, @RequestParam String username, @RequestParam String password){
    	
    	User checkUser; 
    	try {
    		checkUser= userService.GetUserByName(username);
        	if (userService.verifyPassword(username, password) == false) {
        		log.info(username + " - " + password);
        		map.addAttribute("error", "Error Wrong password");
            	return "deniedAccess";
            }
            
            else 
            	return "success";
            
    	} catch (UserNotFoundException unfe) {
    		throw unfe;
    	}
    	
    	

    }
}
