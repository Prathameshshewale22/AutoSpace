package com.app.pojos;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Table(name="payments")
public class Payment extends BaseEntity {

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private PaymentMode paymentMode;
	
	@Column(length=20)
	private String paymentDetails;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	
	@Column(nullable = false)
	private double amt;
	
	@OneToOne(mappedBy = "payment")
	private ServiceBooking booking;
	
	
}
