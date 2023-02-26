package com.app.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VehicleDto {
	
	private Long CustomerId;
	
    private String vehicleNumber;
	
	private String company;
	
	private String model;
	

}
