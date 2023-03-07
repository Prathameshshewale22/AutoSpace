package com.app.services;

import java.util.List;

import com.app.pojos.ServiceBooking;
import com.app.pojos.ServiceCenter;
import com.app.pojos.ServiceStatus;

public interface ServiceBooking_Service {
	
	ServiceBooking addNewBooking(ServiceBooking booking);
	
	List<ServiceBooking> allServiceBookings();
	
	ServiceBooking getServiceBookingById(Long id);
	
	ServiceBooking assignDeliveryBoyById(Long bookingid,Long dboyId);
	
	ServiceBooking updateServiceStatus(Long bookingid,String Status);
	
	List<ServiceBooking> allServiceBookingByStatus(String status);
	
	List<ServiceBooking> allServiceBookByCustomer(Long id);

}
