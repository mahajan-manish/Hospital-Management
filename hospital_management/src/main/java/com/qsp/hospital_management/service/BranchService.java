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
import com.qsp.hospital_management.exception.AddressIdNotFound;
import com.qsp.hospital_management.exception.BranchIdNotFound;
import com.qsp.hospital_management.exception.HospitalIdNotFound;
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
		Branch branchdb = null;
		if (hospital != null && address != null) {
			branch.setHospital(hospital);
			branch.setAddress(address);
			branchdb = branchDao.saveBranch(branch);
			responseStructure.setMessage("branch saved successfully!");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(branchdb);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
		} else if (hospital == null) {
			throw new HospitalIdNotFound("hospital with given id not found");
		}
		throw new AddressIdNotFound("address with given id not found");
	}

	public ResponseEntity<ResponseStructure<List<Branch>>> findAllBranch() {
		List<Branch> branchList = branchDao.findAllAddress();

		if (branchList.isEmpty()) {
			throw new BranchIdNotFound("Branch not Found");
		}
		responseStructureList.setMessage("Branch Found!");
		responseStructureList.setStatus(HttpStatus.FOUND.value());
		responseStructureList.setData(branchList);
		return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructureList, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Branch>> findBranch(int branchId) {
		Branch branch = branchDao.findBranch(branchId);

		if (branch != null) {
			responseStructure.setMessage("Branch Found!");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
		}
		throw new BranchIdNotFound("branch with given id not found");
	}

	public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByHospitalId(int hospitalId) {
		Hospital hospital = hospitalDao.findHospital(hospitalId);
		List<Branch> branchList = branchDao.findBranchByHospital(hospital);
		if (branchList.isEmpty()) {
			throw new BranchIdNotFound("Branch with given hospitalId not Found");
		}
		responseStructureList.setMessage("Branch Found!");
		responseStructureList.setStatus(HttpStatus.FOUND.value());
		responseStructureList.setData(branchList);
		return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructureList, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int branchId, int hospitalId, int addressId,
			Branch branch) {
		Hospital hospital = hospitalDao.findHospital(hospitalId);
		Address address = addressDao.findAddress(addressId);
		Branch branchdb = null;
		if (hospital != null && address != null) {
			branch.setHospital(hospital);
			branch.setAddress(address);
			branchdb = branchDao.updateBranch(branchId, branch);
			if (branchdb != null) {
				responseStructure.setMessage("branch updated successfully!");
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setData(branchdb);
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
			}
			throw new BranchIdNotFound("Branch with given Id not Found");
		} else if (hospital == null) {
			throw new HospitalIdNotFound("hospital with given id not found");
		}
		throw new AddressIdNotFound("address with given id not found");
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int branchId) {
		Branch branch = branchDao.deleteBranch(branchId);
		if (branch != null) {
			responseStructure.setMessage("branch Deleted!");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}
		throw new BranchIdNotFound("Branch with given Id not Found");
	}

}
