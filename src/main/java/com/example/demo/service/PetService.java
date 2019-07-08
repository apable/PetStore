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
		petInfoRepository.save(pet);
	}
	
	public List<Pet> getAllPet()
	{
		return (List<Pet>) petInfoRepository.findAll();
	}
	
	
}
