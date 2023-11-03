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

import com.qsp.hospital_management.dto.Address;
import com.qsp.hospital_management.service.AddressService;
import com.qsp.hospital_management.util.ResponseStructure;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Address>>> findAllAddress() {
		return addressService.findAllAddress();
	}
	
	@GetMapping("/byId")
	public ResponseEntity<ResponseStructure<Address>> findAddress(@RequestParam int addressId) {
		return addressService.findAddress(addressId);
	}
	
	@GetMapping("/byPincode")
	public ResponseEntity<ResponseStructure<Address>> findAddressByPincode(@RequestParam int addressPincode) {
		return addressService.findAddressByPincode(addressPincode);
	}
	
	@PutMapping("/{addressId}")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@PathVariable int addressId , @RequestBody Address address) {
		return addressService.updateAddress(addressId, address);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam int addressId) {
		return addressService.deleteAddress(addressId);
	}
}
