package com.qsp.hospital_management.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int hospitalId;
	
//	@NotBlank(message = "hospital name can't be blank")
//	@NotNull(message = "hospital name cant't be null")
	private String hospitalName;
	
	@Column(unique = true)
//	@NotBlank(message="hospital email can't be blank")
//	@NotNull(message="hospital email can't be null")
//	@Email(regexp = "[a-z0-9._+$]+@[a-z0-9]+\\.[a-z]{2,3}", message = "invalid email")
	private String hospitalEmail;
	
	private String hospitalCEO;
	
}
