package com.example.Authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.Authentication.entities.User;
import com.example.Authentication.services.UserService;

@DataJpaTest
public class UserServiceTest {
	
	@Autowired
	private TestEntityManager eM;

	@Autowired
	private UserService us;
	
	@BeforeEach
	public void bulid() {
		
        eM.persist(new User("Dummy", "test@test.com", "password"));
        
        eM.persist(new User("Dummy2", "test2@test.com", "password2"));
       
        eM.flush();
	}
	
	@Test
	public void testGetAllUsers() {
		
        
        Iterable<User> users = us.GetAllUsers();
        int count = 0;
        for (User user : users) {
            count++; 
        }
        
        assertEquals(count, 2);
	}
	
	public void testGetUserByName() {
		String name = "Dummy";
		User u = us.GetUserByName(name);
		assertEquals(u.getName(), name);
	}
	
	@Test
	public void testVerifyPassword() {
		String username = "Dummy";
		String password = "password";
		boolean b = us.verifyPassword(username, password);
		assertEquals(b, true);
	}
	
}
