package com.qsp.hospital_management.exception;

public class BranchIdNotFound extends RuntimeException {

	private String message;

	public String getMessage() {
		return message;
	}

	public BranchIdNotFound(String message) {
		super();
		this.message = message;
	}
	
}
