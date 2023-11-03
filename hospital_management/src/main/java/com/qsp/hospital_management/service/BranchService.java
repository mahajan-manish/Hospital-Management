package com.qsp.hospital_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_management.dao.AddressDao;
import com.qsp.hospital_management.dao.BranchDao;
import com.qsp.hospital_management.dao.HospitalDao;
import com.qsp.hospital_management.dto.Address;
import com.qsp.hospital_management.dto.Branch;
import com.qsp.hospital_management.dto.Hospital;
import com.qsp.hospital_management.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	private BranchDao branchDao;
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private AddressDao addressDao;
	
	private ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
	private ResponseStructure<List<Branch>> responseStructureList = new ResponseStructure<>();
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(int hospitalId, int addressId, Branch branch) {
		Hospital hospital = hospitalDao.findHospital(hospitalId);
		Address address = addressDao.findAddress(addressId);
		if (hospital!=null && address!=null) {
			branch.setHospital(hospital);
			branch.setAddress(address);
			Branch branchdb = branchDao.saveBranch(hospitalId, addressId, branch);
			responseStructure.setMessage("branch saved successfully!");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(branchdb);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
		}
		
		
		
		
		return null;
	}

	public ResponseEntity<ResponseStructure<List<Branch>>> findAllBranch() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<ResponseStructure<Branch>> findBranch(int branchId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByHospitalId(int hospitalId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int branchId, int hospitalId, int addressId,
			Branch branch) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int branchId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
