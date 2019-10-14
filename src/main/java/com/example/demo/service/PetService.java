package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PetInfoRepository;
import com.example.demo.model.Pet;

@Service
public class PetService {

	@Autowired
	private PetInfoRepository petInfoRepository ;
	public void addPetInfo(Pet pet)
	{
		pet.setPetStatus('A');// Set status as available initially
		petInfoRepository.save(pet);
	}
	
	public List<Pet> getAllPet()
	{
		return (List<Pet>) petInfoRepository.findAll();
	}
	 public void updatePetInfo(Character petStatus , String petName ) 
	{
		petInfoRepository.updatePetInfo(petStatus, petName);
	}
	
	
	
}
