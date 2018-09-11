package com.example.demons.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demons.model.Email;

public interface EmailRepo extends JpaRepository<Email, String>{

	List<Email> findByToId(String id);

}
