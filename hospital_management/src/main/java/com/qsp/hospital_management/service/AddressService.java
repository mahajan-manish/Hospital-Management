package com.qsp.hospital_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_management.dao.AddressDao;
import com.qsp.hospital_management.dto.Address;
import com.qsp.hospital_management.exception.AddressIdNotFound;
import com.qsp.hospital_management.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	private AddressDao addressDao;
	
	private ResponseStructure<Address> responseStructure = new ResponseStructure<>();
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		Address addressdb = addressDao.saveAddress(address);
		responseStructure.setMessage("address save Successfully!");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(addressdb);
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Address>>> findAllAddress() {
		ResponseStructure<List<Address>> responseStructureList = new ResponseStructure<>();
		List<Address> addressList = addressDao.findAllAddress();

		if (addressList.isEmpty()) {
			responseStructureList.setMessage("Address Not Found!");
			responseStructureList.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructureList.setData(addressList);
			return new ResponseEntity<ResponseStructure<List<Address>>>(responseStructureList, HttpStatus.NOT_FOUND);
		}
		responseStructureList.setMessage("Address Found!");
		responseStructureList.setStatus(HttpStatus.FOUND.value());
		responseStructureList.setData(addressList);
		return new ResponseEntity<ResponseStructure<List<Address>>>(responseStructureList, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Address>> findAddress(int addressId) {
		Address address = addressDao.findAddress(addressId);

		if (address != null) {
			responseStructure.setMessage("address Found!");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
		}

		throw new AddressIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Address>> findAddressByPincode(int addressPincode) {
		Address address = addressDao.findAddressByPincode(addressPincode);

		if (address != null) {
			responseStructure.setMessage("address Found!");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
		}

		responseStructure.setMessage("address Not Found!");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(address);
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(int addressId, Address address) {
		Address addressdb = addressDao.updateAddress(addressId, address);

		if (addressdb != null) {
			responseStructure.setMessage("address Updated!");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(addressdb);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		}

		responseStructure.setMessage("address Not Found!");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(addressdb);
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int addressId) {
		Address address = addressDao.deleteAddress(addressId);

		if (address != null) {
			responseStructure.setMessage("address Deleted!");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		}

		responseStructure.setMessage("address Not Found!");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(address);
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.NOT_FOUND);
	}

}
