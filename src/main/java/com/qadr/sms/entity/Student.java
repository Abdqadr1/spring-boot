package com.qadr.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Student class marked with @Entity to tell jpa that this is a table in the database
 * */
@Entity
@Table(name="students") // set the name of the table in the database
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // set the generation type for the primary key
	private Long id;
	@Column(name = "first_name", nullable = false) // set the name of the column in the database and other rules
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	/**
	 * whenever you use a parameter constructor in jpa entity, you should also create a default constructor
	 * because it is internally used by jpa 
	 * */
	public Student () {
		
	}

	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
