package com.qsp.hospital_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospital_management.dto.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	Address findAddressByAddressPincode(int addressPincode);

}
