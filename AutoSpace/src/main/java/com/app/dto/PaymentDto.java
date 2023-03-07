package com.app.dto;

import java.time.LocalDate;

import com.app.pojos.PaymentMode;
import com.app.pojos.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor

@Getter
@Setter
public class PaymentDto {
	
	private String cardNumber;
	
	private LocalDate cardExpireDate;
	
	private Long cvv;
	
	private double amt;
	
	private String upiId;
	
	private PaymentMode paymentMode;
	
	private Long cartId;
	
	private String pickupDropAddress;
	
	private Long ServiceCenterId;
	
	private Long VehicleId;

	public PaymentDto(String cardNumber, LocalDate cardExpireDate, Long cvv, double amt, String upiId,
			String paymentMode, Long cartId,String pickupDropAddress,Long ServiceCenterId,Long vid) {
		super();
		this.cardNumber = cardNumber;
		this.cardExpireDate = cardExpireDate;
		this.cvv = cvv;
		this.amt = amt;
		this.upiId = upiId;
		this.paymentMode = PaymentMode.valueOf(paymentMode.toUpperCase());
		this.cartId = cartId;
		this.pickupDropAddress=pickupDropAddress;
		this.ServiceCenterId=ServiceCenterId;
		VehicleId=vid;
	}
	
	
}
