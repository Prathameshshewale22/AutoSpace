package com.app.pojos;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="vehicles")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Vehicle extends BaseEntity {

	@Column(length=10,unique = true)
	
	private String vehicleNumber;
	
	@Column(length=20)
	private String company;
	
	@Column(length=20)
	private String model;
	
	@ManyToOne
	@JoinColumn(name="customer_id",nullable = false)
	@JsonBackReference
	private Customer customer;
	
//	@OneToOne(mappedBy = "vehicle")
//	private ServiceBooking servicebooking;

	public Vehicle(String vehicleNumber, String company, String model) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.company = company;
		this.model = model;
	}
	
	
}
