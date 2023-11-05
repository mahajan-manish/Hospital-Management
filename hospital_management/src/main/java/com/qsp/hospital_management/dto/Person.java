package com.qsp.hospital_management.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;
	
//	@NotBlank(message = "Name can't be blank")
//	@NotNull(message = "Name cant't be null")
	private String personName;
	
	@Column(unique = true)
//	@Min(value=6000000000l)
//	@Max(value=9999999999l)
	private long personPhone;
	
	@Column(unique = true)
//	@NotBlank(message="email can't be blank")
//	@NotNull(message="email can't be null")
//	@Email(regexp = "[a-z0-9._+$]+@[a-z0-9]+\\.[a-z]{2,3}", message = "invalid email")
	private String personEmail;
	
	private String personAddress;
}
