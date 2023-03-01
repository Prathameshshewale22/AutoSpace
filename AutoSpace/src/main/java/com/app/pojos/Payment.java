package com.app.pojos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

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
	private ServiceBooking booking;
	
	
}
