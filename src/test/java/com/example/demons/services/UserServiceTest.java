package com.example.demons.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demons.model.Email;
import com.example.demons.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	
	@Autowired
	EmailService emailService;

	
	@Test
	public void shouldCreateUser(){
		User u  = userService.create(new User().setName("JOhn Travolta"));
		assertNotNull("id cannot be null", u.getId());

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreateInvalidUser(){
		User u  = userService.create(new User());
	}
	
	@Test
	public void shouldFetchUserWithEmails(){
		User from  = userService.create(new User().setName("JOhn Travolta"));
		User to = userService.create(new User().setName("Totoro"));

		Email email  = emailService.create(new Email().setContent("blah blah")
														.setTitle("Hi !")
														.setSentBy(from)
														.setTo(to));
		
		from = userService.getById(from.getId());
		assertFalse("user's emails is not empty", from.getSentEmails().isEmpty());
		
		for(Email e : from.getSentEmails()){
			System.out.println(e.getSentBy());
			System.out.println(e.getTo());
		}
		
	}

}
