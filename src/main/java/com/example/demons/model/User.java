package com.example.demons.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain=true)
@Entity
@ToString(exclude="sentEmails")
public class User {
	
	@Id
	String id;
	
	String name;
	
	@OneToMany(mappedBy="sentBy", fetch = FetchType.EAGER)
	Set<Email> sentEmails = new HashSet<>();
	
	
	@PrePersist
	void init() {
		this.id = UUID.randomUUID().toString(); 
	}

}
