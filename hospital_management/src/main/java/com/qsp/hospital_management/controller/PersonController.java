package com.qsp.hospital_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hospital_management.dto.Person;
import com.qsp.hospital_management.service.PersonService;
import com.qsp.hospital_management.util.ResponseStructure;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<List<Person>>> findAllPerson() {
		return personService.findAllPerson();
	}

	@GetMapping("/byId")
	public ResponseEntity<ResponseStructure<Person>> findPerson(@RequestParam int personId) {
		return personService.findPerson(personId);
	}
	
	@GetMapping("/byPhone")
	public ResponseEntity<ResponseStructure<Person>> findPersonByPhone(@RequestParam long personPhone) {
		return personService.findPersonByPhone(personPhone);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestParam int personId,
			@RequestBody Person person) {
		return personService.updatePerson(personId, person);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Person>> deletePerson(@RequestParam int personId) {
		return personService.deletePerson(personId);
	}
}
