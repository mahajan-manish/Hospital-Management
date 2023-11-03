package com.qsp.hospital_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospital_management.dto.MedItem;

public interface MedItemRepository extends JpaRepository<MedItem, Integer> {

}
