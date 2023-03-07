package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.ServiceBooking;
import com.app.services.ServiceBooking_ServiceImpl;
import com.app.services.ServiceCenterServiceImpl;

@RestController
@RequestMapping("/servicebooking")
public class ServiceBookingController {
	
	@Autowired
	private ServiceBooking_ServiceImpl service;
	
	@GetMapping
	public List<ServiceBooking> getAllBookings(){
		return service.allServiceBookings();
	}

}
