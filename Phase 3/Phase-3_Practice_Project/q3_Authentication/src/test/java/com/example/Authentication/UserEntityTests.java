package com.example.Authentication;


import com.example.Authentication.entities.User;
import com.example.Authentication.repositories.UserRepository;
import com.example.Authentication.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserEntityTests {

	@Test
	public void WhenSetPassword_CheckGetPassword() {
		User testUser = new User();
		
		testUser.setPassword("Samplepassword");
		assertEquals(testUser.getPassword(),"Samplepassword");
	}

	@Test
	public void WhenSetPassword_CheckPassword() {
		User testUser = new User();
		testUser.setPassword("password");

		String test = testUser.getPassword();
		
		assertEquals(test, "password");
	}
	
	@Test
	public void WhenSetName_CheckGetName() {
		User testUser = new User();
		
		testUser.setName("Samplename");
		assertEquals(testUser.getName(),"Samplename");
	}
	
	@Test
	public void WhenSetName_CheckName() {
		User testUser = new User();
		
		testUser.setName("name");
		assertEquals(testUser.getName(),"name");
	}
	
	@Test
	public void WhenSetEmail_CheckEmail() {
		User testUser = new User();
		testUser.setEmail("sample@test.com");

		String test = testUser.getEmail();
		
		assertEquals(test, "sample@test.com");
	}
	
	@Test
	public void WhenSetEmail_CheckGetEmail() {
		User testUser = new User();
		testUser.setEmail("sample@test.com");

		String test = testUser.getEmail();
		
		assertEquals(test, "sample@test.com");
	}
	
}
