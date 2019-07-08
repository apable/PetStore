package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Person {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id ;
	@NotEmpty(message="Name must not be empty.")
	String personName ;
	int personAge ;
	
	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", personName=" + personName + ", personAge=" + personAge + "]";
	}

	

}
