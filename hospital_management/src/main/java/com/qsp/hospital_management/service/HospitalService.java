package com.qsp.hospital_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_management.dao.HospitalDao;
import com.qsp.hospital_management.dto.Hospital;
import com.qsp.hospital_management.exception.HospitalIdNotFound;
import com.qsp.hospital_management.util.ResponseStructure;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao hospitalDao;

	private ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
	private ResponseStructure<List<Hospital>> responseStructureList = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		hospital = hospitalDao.saveHospital(hospital);
		responseStructure.setMessage("Hospital save Successfully!");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(hospital);
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Hospital>>> findAllHospital() {
		List<Hospital> hospitalList = hospitalDao.findAllHospital();

		if (hospitalList.isEmpty()) {
			responseStructureList.setMessage("Hospital Not Found!");
			responseStructureList.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructureList.setData(hospitalList);
			return new ResponseEntity<ResponseStructure<List<Hospital>>>(responseStructureList, HttpStatus.NOT_FOUND);
		}
		responseStructureList.setMessage("Hospital Found!");
		responseStructureList.setStatus(HttpStatus.FOUND.value());
		responseStructureList.setData(hospitalList);
		return new ResponseEntity<ResponseStructure<List<Hospital>>>(responseStructureList, HttpStatus.FOUND);

	}

	public ResponseEntity<ResponseStructure<Hospital>> findHospital(int hospitalId) {

		Hospital hospital = hospitalDao.findHospital(hospitalId);

		if (hospital != null) {
			responseStructure.setMessage("Hospital Found!");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.FOUND);
		}

		throw new HospitalIdNotFound("Hopital with given Id does not Exist");

	}

	public ResponseEntity<ResponseStructure<Hospital>> findHospitalByEmail(String hospitalEmail) {
		Hospital hospital = hospitalDao.findHospitalByHospitalEmail(hospitalEmail);

		if (hospital != null) {
			responseStructure.setMessage("Hospital Found!");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.FOUND);
		}
		responseStructure.setMessage("Hospital Not Found!");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(hospital);
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int hospitalId, Hospital hospital) {
		hospital = hospitalDao.updateHospital(hospitalId, hospital);

		if (hospital != null) {
			responseStructure.setMessage("Hospital Updated!");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
		}

		responseStructure.setMessage("Hospital Not Found!");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(hospital);
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int hospitalId) {
		Hospital hospital = hospitalDao.deleteHospital(hospitalId);

		if (hospital != null) {
			responseStructure.setMessage("Hospital Deleted!");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
		}
		responseStructure.setMessage("Hospital Not Found!");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(hospital);
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.NOT_FOUND);
	}

}
