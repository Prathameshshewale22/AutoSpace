package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="service_bookings")
public class ServiceBooking extends BaseEntity {
    @Enumerated(EnumType.STRING)
	private ServiceStatus status;
	
	@Column(length=200)
	private String pickupDropAddress;
	
	@OneToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	@JsonBackReference
	private Customer customer; 
	
	@ManyToOne
	@JoinColumn(name="serviceCenter_id")
	@JsonBackReference
	private ServiceCenter serviceCenter;
	
	@OneToOne
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "service_id"), inverseJoinColumns = @JoinColumn(name = "booking_id"))
	private List<Services> ServicesToDone=new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name="deliveryBoy_id")
	private DeliveryBoy deliveryBoy;
	
	public ServiceBooking() {
		this.status=ServiceStatus.PENDING;
	}
	
	public void addPayment(Payment payment) {
		this.setPayment(payment);
		payment.setBooking(this);
	}
	
	public void addCustomer(Customer cust) {
		this.setCustomer(cust);
		cust.getBookings().add(this);
	}
	
	public void addServiceCenter(ServiceCenter center) {
		this.setServiceCenter(center);
		center.getBookings().add(this);
	}
	
	public void addVehicle(Vehicle vehicle) {
		this.setVehicle(vehicle);
	}
	
	public void addService(Services service) {
		this.ServicesToDone.add(service);
	}
	
	public void addDeliveryBoy(DeliveryBoy dBoy) {
		this.setDeliveryBoy(dBoy);
	}
}
