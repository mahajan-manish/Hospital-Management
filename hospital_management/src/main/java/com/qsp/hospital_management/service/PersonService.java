package com.qsp.hospital_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_management.dao.PersonDao;
import com.qsp.hospital_management.dto.Person;
import com.qsp.hospital_management.exception.PersonIdNotFound;
import com.qsp.hospital_management.util.ResponseStructure;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;
	
	private ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
	private ResponseStructure<List<Person>> responseStructureList = new ResponseStructure<List<Person>>();

	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person) {
		Person persondb = personDao.savePerson(person);
		responseStructure.setMessage("Person Saved Successfully!");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(persondb);
		return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Person>>> findAllPerson() {
		List<Person> personList = personDao.findAllPerson();
		if (personList.isEmpty()) {
			throw new PersonIdNotFound("Person Not Found");
		}
		responseStructureList.setMessage("Person Found!");
		responseStructureList.setStatus(HttpStatus.FOUND.value());
		responseStructureList.setData(personList);
		return new ResponseEntity<ResponseStructure<List<Person>>>(responseStructureList, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Person>> findPerson(int personId) {
		Person person = personDao.findPerson(personId);
		if (person!=null) {
			responseStructure.setMessage("Person Found!");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.FOUND);
			
		}
		throw new PersonIdNotFound("Person with given id not found!");
	}
	
	public ResponseEntity<ResponseStructure<Person>> findPersonByPhone(long personPhone) {
		Person person = personDao.findPersonByPhone(personPhone);
		if (person!=null) {
			responseStructure.setMessage("Person Found!");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.FOUND);	
		}
		throw new PersonIdNotFound("Person with give Phone Number not found!");
	}

	public ResponseEntity<ResponseStructure<Person>> updatePerson(int personId, Person person) {
		Person persondb = personDao.updatePerson(personId, person);
		if(persondb!=null) {
			responseStructure.setMessage("Person updated successfully!");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(persondb);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.OK);
		}
		throw new PersonIdNotFound("Person with given id not found!");
	}

	public ResponseEntity<ResponseStructure<Person>> deletePerson(int personId) {
		Person person = personDao.deletePerson(personId);
		if (person!=null) {
			responseStructure.setMessage("Person Deleted!");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.OK);
		}
		throw new PersonIdNotFound("Person with given id not Found!");
	}
	
}
