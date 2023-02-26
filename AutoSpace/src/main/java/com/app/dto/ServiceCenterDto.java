package com.app.dto;

import javax.persistence.Column;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ServiceCenterDto {

	private String centerName;

	private String centerAddress;

	private String city;

	private String zipcode;

	private String contactNumber;

	private String email;

}
