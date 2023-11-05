package com.qsp.hospital_management.exception;

public class PersonIdNotFound extends RuntimeException {

	private String message;

	public String getMessage() {
		return message;
	}

	public PersonIdNotFound(String message) {
		super();
		this.message = message;
	}
	
}
