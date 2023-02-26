package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="service_bookings")
public class ServiceBooking extends BaseEntity {
    @Enumerated(EnumType.STRING)
	private ServiceStatus status;
	
	@Column(length=50)
	private String pickupDropAddress;
	
	@OneToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer; 
	
	@ManyToOne
	@JoinColumn(name="serviceCenter_id")
	private ServiceCenter serviceCenter;
	
	@OneToOne
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;
	
	@OneToOne
	@JoinColumn(name="service_id")
	private Services service;
	
	@OneToOne
	@JoinColumn(name="deliveryBoy_id")
	private DeliveryBoy deliveryBoy;
	
}
