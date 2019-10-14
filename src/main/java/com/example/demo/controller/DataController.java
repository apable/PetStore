package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.JwtResponse;
import com.example.demo.model.Person;
import com.example.demo.model.Pet;
import com.example.demo.model.User;
import com.example.demo.service.PersonService;
import com.example.demo.service.PetService;
import com.example.demo.utils.JwtTokenUtility;

@RestController
@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders = "*")
public class DataController {

	@Autowired
	private PersonService personService ;
	@Autowired
	private PetService petService ;
	
	@Autowired
	private JwtTokenUtility jwtTokenUtility;


	
	@RequestMapping ("/addData")
	public String addData (Person person, Pet pet)
	{
//		personInfo.save(person);
//		petInfo.save(pet);
		return "home.jsp";
	}
	
	@RequestMapping(value="/persons" ,method=RequestMethod.POST)
	public ResponseEntity<?> addPersonInfo (@RequestBody Person person )
	{
		personService.addPersonInfo(person);
		
		if(person.getPetName()!=null && !person.getPetName().isEmpty()) 
		{
			petService.updatePetInfo('S', person.getPetName() );
			petService.getAllPet();
		}
		
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
	
	@RequestMapping(value="/pets" ,method=RequestMethod.POST)
	public ResponseEntity<?> addPetInfo (@RequestBody  Pet pet)
	{
		petService.addPetInfo(pet);
		return new ResponseEntity<Pet>(pet, HttpStatus.OK);
	}
	
	@RequestMapping(value="/persons" ,method=RequestMethod.GET)
	public ResponseEntity<?>getPersonInfo ()
	{
		List<Person> person = personService.getAllPerson();
		return new ResponseEntity<>(person, HttpStatus.OK); 
	}

	@RequestMapping(value="/pets" ,method=RequestMethod.GET)
	public ResponseEntity <?> getPetInfo ()
	{ 
		List<Pet> pet = petService.getAllPet();
		return new ResponseEntity<>(pet, HttpStatus.OK);
	}
	
	@PostMapping("/users/authenticate")
	public ResponseEntity <?>  authenticate (@RequestBody User user)
	{
		if((user.getUsername()!=null && !user.getUsername().isEmpty()) && 
				(user.getPassword()!=null && !user.getPassword().isEmpty())  )
		{
			if(user.getUsername().equals("admin") && user.getPassword().equals("admin"))
			{
				final String token = jwtTokenUtility.generateToken(user);
				return ResponseEntity.ok(new JwtResponse(token));
//				return new ResponseEntity<User> (user, HttpStatus.OK);
			}
			else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Invalid username or password.");
			}
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid username or password.");
		}
	}
}
