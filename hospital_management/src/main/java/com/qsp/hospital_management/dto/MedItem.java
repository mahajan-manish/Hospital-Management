package com.qsp.hospital_management.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class MedItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medItemId;
	private String medItemName;
	private double medItemPrice;
	@ManyToOne
	private MedOrder medOrder;
}
