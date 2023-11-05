package com.qsp.hospital_management.exception;

public class AddressIdNotFound extends RuntimeException {

	private String message;

	public String getMessage() {
		return message;
	}

	public AddressIdNotFound(String message) {
		super();
		this.message = message;
	}

}
