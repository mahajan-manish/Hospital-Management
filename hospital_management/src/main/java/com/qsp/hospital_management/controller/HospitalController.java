package com.qsp.hospital_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hospital_management.dto.Hospital;
import com.qsp.hospital_management.service.HospitalService;
import com.qsp.hospital_management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	@ApiOperation(notes="This API is used to save the hospital details into the database", value="Save Hospital")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "data saved successfully")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital) {
		return hospitalService.saveHospital(hospital);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<List<Hospital>>> findAllHospital() {
		return hospitalService.findAllHospital();
	}

	@GetMapping("/byId")
	public ResponseEntity<ResponseStructure<Hospital>> findHospital(@RequestParam int hospitalId) {
		return hospitalService.findHospital(hospitalId);
	}

	@GetMapping("/byEmail")
	public ResponseEntity<ResponseStructure<Hospital>> findHospitalByEmail(@RequestParam String hospitalEmail) {
		return hospitalService.findHospitalByEmail(hospitalEmail);
	}

	@PutMapping("/{hospitalId}")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@PathVariable int hospitalId,
			@RequestBody Hospital hospital) {
		return hospitalService.updateHospital(hospitalId, hospital);
	}

	@DeleteMapping("/{hospitalId}")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@PathVariable int hospitalId) {
		return hospitalService.deleteHospital(hospitalId);
	}
}
