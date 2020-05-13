package com.cc.spring.data.baseapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Book {

	@Id
	private int isbn;
	private String title;
	private Category category;
	private String authorEmail;
	private String publisher;
	
}
