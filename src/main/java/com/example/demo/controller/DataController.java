package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.PersonInfoRepository;
import com.example.demo.dao.PetInfoRepository;
import com.example.demo.model.Person;
import com.example.demo.model.Pet;
import com.example.demo.model.User;
import com.example.demo.service.PersonService;
import com.example.demo.service.PetService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DataController {

	@Autowired
	private PersonService personService ;
	@Autowired
	private PetService petService ;
	
	@RequestMapping ("/addData")
	public String addData (Person person, Pet pet)
	{
//		personInfo.save(person);
//		petInfo.save(pet);
		return "home.jsp";
	}
	
	@PostMapping("/addPerson")
	public ResponseEntity<Person> addPersonInfo (@RequestBody Person person)
	{
		personService.addPersonInfo(person);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
	
	@PostMapping("/addPet")
	public ResponseEntity<Pet> addPetInfo (@RequestBody  Pet pet)
	{
		petService.addPetInfo(pet);
		return new ResponseEntity<Pet>(pet, HttpStatus.OK);
	}
	
	@GetMapping("/getPerson")
	public ResponseEntity<List<Person>>getPersonInfo ()
	{
		
		List<Person> person = personService.getAllPerson();
		return new ResponseEntity<>(person, HttpStatus.OK); 
		
//		List<Person> person;
//		try {
//		 person =(List<Person>) personInfo.findAll();
//		}catch (Exception ex) { // TODO - Add a custom exception
//            return new ResponseEntity<>(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
//        } 
//		 return new ResponseEntity<>(person, HttpStatus.OK);
	}

	@GetMapping("/getPet")
	public ResponseEntity <List<Pet>> getPetInfo ()
	{ 
		List<Pet> pet = petService.getAllPet();
		return new ResponseEntity<>(pet, HttpStatus.OK);
//		List<Pet> pet ; 
//		try {
//		pet =(List<Pet>) petInfo.findAll();
//		}catch (Exception e) {
//			// TODO: handle exception
//			return new ResponseEntity<>(null, null , HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		 return new ResponseEntity<>(pet, HttpStatus.OK);
	}
	
	@PostMapping("/users/authenticate")
	public ResponseEntity <User>  authenticate (@RequestBody User user)
	{
		if(user.getUsername().equals("admin") && user.getPassword().equals("admin")){
			return new ResponseEntity<User> (user, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<User> (user,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
