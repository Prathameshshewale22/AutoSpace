package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.ServiceBooking;
import com.app.repository.ServiceBookingRepository;

@Service
@Transactional
public class ServiceBooking_ServiceImpl implements ServiceBooking_Service {

	@Autowired
	private ServiceBookingRepository sbRepo;
	
	@Override
	public ServiceBooking addNewBooking(ServiceBooking booking) {
		
		return sbRepo.save(booking);
	}

	@Override
	public List<ServiceBooking> allServiceBookings() {
		List<ServiceBooking> all = sbRepo.findAll();
		all.forEach(s->s.getCustomer().getCustomerCart().getCartItems().size());
		all.forEach(b->b.getServicesToDone().size());
		return all;
	}

}
