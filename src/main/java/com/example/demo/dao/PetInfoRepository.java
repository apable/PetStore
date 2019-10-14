package com.example.demo.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Pet;

@Repository
public interface PetInfoRepository extends CrudRepository<Pet, Integer> {
	@Transactional
	@Modifying
	@Query("update Pet p set p.petStatus = ?1 where p.petName = ?2")
	 void updatePetInfo(Character petStatus , String petName ); 
}
