package com.qsp.hospital_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospital_management.dto.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

	Hospital findHospitalByHospitalEmail(String hospitalEmail);

}
