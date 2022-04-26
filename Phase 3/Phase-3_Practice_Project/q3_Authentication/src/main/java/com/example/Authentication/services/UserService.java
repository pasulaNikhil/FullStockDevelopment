package com.example.Authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Authentication.entities.User;
import com.example.Authentication.exceptions.UserNotFoundException;
import com.example.Authentication.repositories.UserRepository;



@Service
public class UserService {
	
	@Autowired
	 private UserRepository userRepository;
	
	

    public Iterable<User> GetAllUsers()
    {
        return userRepository.findAll();
    }


    public User GetUserByName(String name) {
        Optional<User> foundUser = userRepository.findByName(name);
        if (!foundUser.isPresent()) {
    		throw new UserNotFoundException();
    	}
    	
    	return(foundUser.get());
        
    }
    /*
    public User GetUserById(int id) {
    	Optional<User> foundUser = userRepository.findById(id);
    	
    	
    	//TODO: we need to decide how to handle a "Not Found" condition
    	
    	if (!foundUser.isPresent()) {
    		throw new UserNotFoundException();
    	}
    	
    	return(foundUser.get());
    }*/
    
    public boolean verifyPassword(String username, String password) {
    	boolean verified = false;
    	User user = GetUserByName(username);
    	
    	if (user.getPassword().equals(password)) {
    		verified = true;
    	}
    	
    	return verified;
    }
    
    //Do we need this?
    /*public void UpdateUser(User usertoUpdate) {
    	userRepository.save(usertoUpdate);
    }*/


}
