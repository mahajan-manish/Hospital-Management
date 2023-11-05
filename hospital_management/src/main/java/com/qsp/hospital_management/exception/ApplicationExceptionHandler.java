package com.qsp.hospital_management.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.hospital_management.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(HospitalIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(HospitalIdNotFound exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setMessage("Hospital Not Found Exception");
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(AddressIdNotFound exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setMessage("Address Not Found Exception");
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(BranchIdNotFound exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setMessage("Branch Not Found Exception");
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PersonIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(PersonIdNotFound exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setMessage("Person Not Found Exception");
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> list = ex.getAllErrors();
		Map<String, String> map = new HashMap<>();
		for (ObjectError objectError : list) {
			FieldError fieldError = (FieldError) objectError;
			String fieldName = fieldError.getField();
			String message = fieldError.getDefaultMessage();
			map.put(fieldName, message);
		}
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}
}
