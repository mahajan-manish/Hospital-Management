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

import com.qsp.hospital_management.dto.Branch;
import com.qsp.hospital_management.service.BranchService;
import com.qsp.hospital_management.util.ResponseStructure;

@RestController
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	private BranchService branchService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestParam int hospitalId,
			@RequestParam int addressId, @RequestBody Branch branch) {
		return branchService.saveBranch(hospitalId, addressId, branch);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<List<Branch>>> findAllBranch() {
		return branchService.findAllBranch();
	}

	@GetMapping("/byId")
	public ResponseEntity<ResponseStructure<Branch>> findBranch(@RequestParam int branchId) {
		return branchService.findBranch(branchId);
	}

	@GetMapping("/byHospitalId")
	public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByHospitalId(@RequestParam int hospitalId) {
		return branchService.findBranchByHospitalId(hospitalId);
	}

	@PutMapping("/{branchId}")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@PathVariable int branchId,
			@RequestParam int hospitalId, @RequestParam int addressId, @RequestBody Branch branch) {
		return branchService.updateBranch(branchId, hospitalId, addressId, branch);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@RequestParam int branchId) {
		return branchService.deleteBranch(branchId);
	}
}
