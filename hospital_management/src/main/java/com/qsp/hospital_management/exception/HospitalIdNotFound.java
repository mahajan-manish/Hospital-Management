package com.qsp.hospital_management.exception;

public class HospitalIdNotFound extends RuntimeException {

	private String message;

	public String getMessage() {
		return message;
	}

	public HospitalIdNotFound(String message) {
		super();
		this.message = message;
	}
	
}
