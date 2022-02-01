package com.qadr.sms.entity;

import javax.persistence.*;

/**
 * Student class marked with @Entity to tell jpa that this class maps to a table in the database
 * */
@Entity
@Table(
		name="students",
		uniqueConstraints = {
				@UniqueConstraint(name = "email_unique", columnNames = "email") // for changing the name of the email uniqueness constraint
		}) // set the name of the table in the database
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // set the generation type for the primary key
	/**
	 * We can also use the sequence generator for the generatedvalue
	 * @SequenceGenerator(
	 * 	name='student_sequence',
	 * 	sequenceName = 'student_sequence,
	 * 	allocationSize = 1)
	 * */
	private Long id;
	@Column(name = "first_name",
			nullable = false,
			columnDefinition = "TEXT") // set the name of the column in the database and other rules
	private String firstName;
	
	@Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
	private String lastName;
	
	@Column(name = "email", nullable = false, columnDefinition = "VARCHAR(255)")
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
