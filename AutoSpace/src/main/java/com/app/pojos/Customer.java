package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
@Table(name = "customers")
public class Customer extends BaseEntity {

	@Column(length = 20)
	private String firstName;

	@Column(length = 20)
	private String lastName;

	@Column(length = 40,unique=true,nullable = false)
	private String email;

	@Column(length = 20,unique = true,nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	@Column(length = 10,unique = true)
	private String mobileNumber;
	
	@Column(length = 200)
	private String address;
	
	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
	private List<Vehicle> vehicles=new ArrayList<Vehicle>();
	
	@OneToOne(mappedBy = "cartOwner",cascade = CascadeType.ALL,orphanRemoval = true)
	//empty cart for every customer
	private Cart customerCart;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
	private List<ServiceBooking> bookings=new ArrayList<>();

	public Customer(String firstName, String lastName, String email, String password, String mobileNumber,
			String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}
	
	public void addVehicle(Vehicle newVehicle) {
		this.vehicles.add(newVehicle);
		newVehicle.setCustomer(this);
	}
	
	public void addCart(Cart customerCart) {
		this.setCustomerCart(customerCart);
		customerCart.setCartOwner(this);
	}

}
