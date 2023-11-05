package com.qsp.hospital_management.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class MedOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medOrderId;
	
	private String medOrderDate;
	
	private String medOrderDoctor;
	
	@ManyToOne
	private  Encounter encounter;
}
