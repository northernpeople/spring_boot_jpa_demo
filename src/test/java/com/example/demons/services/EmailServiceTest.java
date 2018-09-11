package com.example.demons.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demons.model.Email;
import com.example.demons.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailServiceTest {
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	UserService userService;
	
	User from;
	User to;
	
	@Before
	public void setUp(){
		from = userService.create(new User().setName("Jamy roquay"));
		to = userService.create(new User().setName("Totoro"));

	}
	
	@Test
	public void shouldCreateEmail(){
		Email email = new Email().setContent("blah blah")
				.setTitle("Hi !")
				.setSentBy(from)
				.setTo(to);
		email = emailService.create(email);
		assertNotNull("id cannot be null", email.getId());

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreateEmailWithoutFromUser(){
		Email email = new Email().setContent("blah blah")
				.setTitle("Hi !")
				.setTo(to);
		
		email = emailService.create(email);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreateEmailWithoutContent(){
		Email email = new Email()
				.setTitle("Hi !")
				.setSentBy(from)
				.setTo(to);
		
		email = emailService.create(email);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreateEmailWithoutTitle(){
		Email email = new Email()
				.setContent("blah blah")
				.setSentBy(from)
				.setTo(to);		
		email = emailService.create(email);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreateEmailWithoutToUser(){
		Email email = new Email()
				.setContent("blah blah")
				.setTitle("Hi !")
				.setSentBy(from);		
		email = emailService.create(email);
	}
	
	@Test
	public void shouldFetchUserWithEmails(){
		User from  = userService.create(new User().setName("JOhn Travolta"));
		User to = userService.create(new User().setName("Totoro"));
		
		

		emailService.create(new Email().setContent("blah blah")
				.setTitle("Hi !")
				.setSentBy(from)
				.setTo(to));
		emailService.create(new Email().setContent("blah blah")
				.setTitle("Assalam aleikum")
				.setSentBy(from)
				.setTo(to));
		emailService.create(new Email().setContent("blah blah")
				.setTitle("Nihao")
				.setSentBy(from)
				.setTo(to));

		
		
		for(Email e : emailService.findEmailsSentTo(to)){
			System.out.println(e);
		}
		
		assertFalse("emails sent to user should not be empty", emailService.findEmailsSentTo(to).isEmpty());
		
		
		
	}

	
	
	

}
