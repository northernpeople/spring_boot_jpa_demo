package com.example.demons.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demons.model.Email;
import com.example.demons.model.User;

public interface UserRepo extends JpaRepository<User, String>{

}
