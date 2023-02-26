package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ServiceCenter extends BaseEntity {
 
	@Column(length = 20,unique = true,nullable = false)
	private String centerName;
	
	@Column(length = 50)
	private String centerAddress;
	
	@Column(length = 20)
	private String City;
	
	@Column(length = 10)
	private String Zipcode;

	@Column(length=12)
	private String contactNumber;
	
	@Column(length = 15,unique = true,nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "serviceCenter")
	private List<ServiceBooking> bookings=new ArrayList<>();
}
