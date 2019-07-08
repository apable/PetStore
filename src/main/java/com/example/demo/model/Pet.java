package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Pet {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	int petId;
	@NotEmpty(message="Name must not be empty.")
	String petName ;
	String petColor;
	


	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", petName=" + petName + ", petColor=" + petColor + "]";
	}

	public String getPetColor() {
		return petColor;
	}

	public void setPetColor(String petColor) {
		this.petColor = petColor;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

}
