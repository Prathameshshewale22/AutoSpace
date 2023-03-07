package com.app.services;

import java.util.List;

import com.app.pojos.ServiceBooking;

public interface ServiceBooking_Service {
	
	ServiceBooking addNewBooking(ServiceBooking booking);
	
	List<ServiceBooking> allServiceBookings();

}
