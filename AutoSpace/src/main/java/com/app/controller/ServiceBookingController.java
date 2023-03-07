package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.ServiceBooking;
import com.app.services.ServiceBooking_ServiceImpl;

@RestController
@RequestMapping("/servicebooking")
public class ServiceBookingController {
	
	@Autowired
	private ServiceBooking_ServiceImpl service;
	
	@GetMapping
	public List<ServiceBooking> getAllBookings(){
		return service.allServiceBookings();
	}
	
	@PatchMapping("/updatestatus")
	public ServiceBooking assignDeliveryBoy(@PathVariable Long bookingid,@PathVariable Long deliveryboyid) {
		return service.assignDeliveryBoyById(bookingid, deliveryboyid);
	}
	
	@GetMapping("/{id}")
	public ServiceBooking getBookingById(@PathVariable Long id ) {
		 return service.getServiceBookingById(id);
	}
    
	@GetMapping("{bookingid}/{status}")
	public ServiceBooking updateBookingStatus(@RequestParam Long bookingid,@RequestParam String status) {
		return service.updateServiceStatus(bookingid, status);
	}
	
	@GetMapping("/status")
	public List<ServiceBooking> getAllCompletedServicing(@RequestParam String status){
		return service.allServiceBookingByStatus(status);
	}
	
	@GetMapping("/customerbooking/{customerId}")
	public List<ServiceBooking> getAllServicesByCustomerId(Long customerId){
		return service.allServiceBookByCustomer(customerId);
	}
	
}
