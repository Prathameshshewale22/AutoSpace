package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PaymentDto;
import com.app.pojos.ServiceBooking;
import com.app.services.PaymentServiceImpl;


@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentServiceImpl paymentService;
	
	
	@PostMapping
	public ServiceBooking paymentProcessing(@RequestBody PaymentDto paymentObj) {
		return paymentService.doPayment(paymentObj);
	}

}
