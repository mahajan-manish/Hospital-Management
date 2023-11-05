package com.qsp.hospital_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.qsp.hospital_management.dto.Branch;
import com.qsp.hospital_management.dto.Hospital;

public interface BranchRepository extends JpaRepository<Branch, Integer> {

//	@Query("SELECT branch FROM Branch branch WHERE branch.hospital=?1")
	List<Branch> findBranchByHospital(Hospital hospital);
}
