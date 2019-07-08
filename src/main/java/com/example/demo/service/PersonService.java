package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonInfoRepository;
import com.example.demo.model.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonInfoRepository personInfoRepository ;
	public void addPersonInfo(Person person)
	{
		personInfoRepository.save(person);
	}
	
	public List<Person> getAllPerson()
	{
		return (List<Person>) personInfoRepository.findAll();
	}
	
	
	

}
