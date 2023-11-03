package com.qsp.hospital_management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_management.dto.Hospital;
import com.qsp.hospital_management.repository.HospitalRepository;

@Repository
public class HospitalDao {

	@Autowired
	private HospitalRepository hospitalRepository;

	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	public Hospital findHospital(int hospitalId) {
		Optional<Hospital> optional = hospitalRepository.findById(hospitalId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Hospital deleteHospital(int hospitalId) {
		Optional<Hospital> optional = hospitalRepository.findById(hospitalId);
		if (optional.isEmpty()) {
			return null;	
		}
		Hospital hospital = optional.get();
		hospitalRepository.delete(hospital);
		return hospital;
		
	}

	public Hospital updateHospital(int hospitalId, Hospital hospital) {
		Optional<Hospital> optional = hospitalRepository.findById(hospitalId);
		if (optional.isEmpty()) {
			return null;	
		}
		hospital.setHospitalId(hospitalId);
		return hospitalRepository.save(hospital);
	}

	public Hospital findHospitalByHospitalEmail(String hospitalEmail) {
		return hospitalRepository.findHospitalByHospitalEmail(hospitalEmail);
	}

	public List<Hospital> findAllHospital() {
		return hospitalRepository.findAll();
	}

}
