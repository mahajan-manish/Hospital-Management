package com.qsp.hospital_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospital_management.dto.MedOrder;

public interface MedOrderRepository extends JpaRepository<MedOrder, Integer> {

}
