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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ServiceCenter extends BaseEntity {

	@Column(length = 20,unique = true,nullable = false)
	private String centerName;
	
	@Column(length = 50)
	private String centerAddress;
	
	@Column(length = 20)
	private String city;
	
	@Column(length = 10)
	private String zipcode;

	@Column(length=12)
	private String contactNumber;
	
	@Column(length = 50,unique = true,nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "serviceCenter",fetch = FetchType.EAGER)
	private List<ServiceBooking> bookings=new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name="manager_id")
	private Manager centerManager;
	
	@OneToMany(mappedBy = "scenter",fetch = FetchType.EAGER)
	public List<DeliveryBoy> deliveryBoys=new ArrayList<>();
	
	public ServiceCenter(String centerName, String centerAddress, String city, String zipcode, String contactNumber,
			String email) {
		super();
		this.centerName = centerName;
		this.centerAddress = centerAddress;
		this.city = city;
		this.zipcode = zipcode;
		this.contactNumber = contactNumber;
		this.email = email;
	}
	
	public void addManager(Manager centerManager) {
		this.setCenterManager(centerManager);
	}
	
	public void addDeliveryBoy(DeliveryBoy deliveryBoy) {
		this.deliveryBoys.add(deliveryBoy);
		deliveryBoy.setScenter(this);
	}
	
}
