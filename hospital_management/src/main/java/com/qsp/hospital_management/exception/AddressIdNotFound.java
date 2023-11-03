package com.qsp.hospital_management.exception;

public class AddressIdNotFound extends RuntimeException {

	private String message = "Address with given Id does not Exist";

	public String getMessage() {
		return message;
	}

}
