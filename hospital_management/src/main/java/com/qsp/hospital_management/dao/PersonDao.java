package com.qsp.hospital_management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_management.dto.Person;
import com.qsp.hospital_management.repository.PersonRepository;

@Repository
public class PersonDao {

	@Autowired
	private PersonRepository personRepository;

	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	public List<Person> findAllPerson() {
		return personRepository.findAll();
	}

	public Person deletePerson(int personId) {
		Optional<Person> optional = personRepository.findById(personId);
		if (optional.isPresent()) {
			Person person = optional.get();
			personRepository.delete(person);
			return person;
		}
		return null;
	}

	public Person findPerson(int personId) {
		// TODO Auto-generated method stub
		return null;
	}

}
