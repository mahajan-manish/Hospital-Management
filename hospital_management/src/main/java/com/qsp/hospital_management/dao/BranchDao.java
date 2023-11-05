package com.qsp.hospital_management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_management.dto.Branch;
import com.qsp.hospital_management.dto.Hospital;
import com.qsp.hospital_management.repository.BranchRepository;

@Repository
public class BranchDao {
	
	@Autowired
	private BranchRepository branchRepository;

	public Branch saveBranch(Branch branch) {
		return branchRepository.save(branch);
	}

	public List<Branch> findAllAddress() {
		return branchRepository.findAll()  ;
	}

	public Branch findBranch(int branchId) {
	  	Optional<Branch> optional = branchRepository.findById(branchId);
	  	if (optional.isPresent()) {
			return optional.get();
		}
	  	return null;
	}

	public List<Branch> findBranchByHospital(Hospital hospital) {
		return branchRepository.findBranchByHospital(hospital);
	}

	public Branch updateBranch(int branchId, Branch branch) {
		Optional<Branch> optional = branchRepository.findById(branchId);
	  	if (optional.isPresent()) {
	  		branch.setBranchId(branchId);
	  		return branchRepository.save(branch);
		}
		return null;
	}

	public Branch deleteBranch(int branchId) {
		Optional<Branch> optional = branchRepository.findById(branchId);
	  	if (optional.isPresent()) {
	  		Branch branch = optional.get();
	  		branchRepository.delete(branch);
	  		return branch;
		}
		return null;
	}

}
