package com.example.demons.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.demons.model.Email;
import com.example.demons.model.User;
import com.example.demons.repo.EmailRepo;

@Service
public class EmailService {
	
	@Autowired
	EmailRepo repo;
	
	
	public Email create(Email email){
		Assert.notNull(email, "email cannot be null");
		Assert.notNull(email.getContent(), "email content cannot be null");
		Assert.notNull(email.getTitle(), "email title cannot be null");
		Assert.notNull(email.getSentBy(), "email author cannot be null");
		Assert.notNull(email.getSentBy().getId(), "email author id cannot be null");
		Assert.notNull(email.getTo(), "email adressee cannot be null");
		Assert.notNull(email.getTo().getId(), "email adressee id cannot be null");
		
		return repo.saveAndFlush(email);
	}
	
	public List<Email> findEmailsSentTo(User u){
		return repo.findByToId(u.getId());
	}

}
