package com.qsp.hospital_management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_management.dto.Address;
import com.qsp.hospital_management.repository.AddressRepository;

@Repository
public class AddressDao {
	
	@Autowired
	private AddressRepository addressRepository;

	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}

	public Address findAddress(int addressId) {
		Optional<Address> optional = addressRepository.findById(addressId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Address findAddressByPincode(int addressPincode) {
		return addressRepository.findAddressByAddressPincode(addressPincode);
	}

	public Address updateAddress(int addressId, Address address) {
		Optional<Address> optional = addressRepository.findById(addressId);
		if (optional.isPresent()) {
			address.setAddressId(addressId);
			return addressRepository.save(address);
		}
		return null;
	}

	public Address deleteAddress(int addressId) {
		Optional<Address> optional = addressRepository.findById(addressId);
		if (optional.isPresent()) {
			Address address = optional.get();
			addressRepository.delete(address);
			return address;
		}
		return null;
	}

	public List<Address> findAllAddress() {
		return addressRepository.findAll();
	}

}
