package com.example.demons.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain=true)
@Entity
@ToString
public class Email {
	
	@Id
	String id;
	
	
	@ManyToOne
	User sentBy;
	
	//unidirectional: entity with Annotation is always the owner.
	@OneToOne
	User to;
	
	String title;
	String content;
	
	
	@PrePersist
	void init() {
		this.id = UUID.randomUUID().toString(); 
	}

}
