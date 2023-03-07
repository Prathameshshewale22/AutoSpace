package com.app.pojos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	
	@Column(length=40)
	private String CardNumber;
	
	@Column(length=30)
	private String upiId;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	
	@Column(nullable = false)
	private double amt;
	
	@CreationTimestamp
	private LocalDateTime paymentDateTime;
	
	@OneToOne(mappedBy = "payment")
	@JsonBackReference
	private ServiceBooking booking;
	
	@OneToOne
	@JoinColumn(name="cart_Id")
	private Cart cart;

	public Payment(PaymentMode paymentMode, String cardNumber, String upiId, double amt) {
		super();
		this.paymentMode = paymentMode;
		CardNumber = cardNumber;
		this.upiId = upiId;
		this.amt = amt;
		this.paymentStatus=PaymentStatus.PENDING;
	}
	
	public void addCart(Cart cart) {
		this.setCart(cart);
	}
	
	
}
