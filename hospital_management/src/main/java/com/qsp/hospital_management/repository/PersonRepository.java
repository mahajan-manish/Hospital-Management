package com.qsp.hospital_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospital_management.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	Person findPersonByPersonPhone(long personPhone);

}
