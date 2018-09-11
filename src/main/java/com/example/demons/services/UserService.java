package com.example.demons.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.demons.model.User;
import com.example.demons.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo repo;
	
	public User create(User user){
		Assert.notNull(user, "user cannot be null");
		Assert.notNull(user.getName(), "user name cannot be null");
		return  repo.saveAndFlush(user);
	}
	
	public User getById(String id){
		return repo.findById(id).get();
	}

}
