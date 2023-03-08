package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.pojos.DeliveryBoy;
import com.app.pojos.ServiceBooking;
import com.app.pojos.ServiceCenter;
import com.app.pojos.ServiceStatus;
import com.app.repository.ServiceBookingRepository;

@Service
@Transactional
public class ServiceBooking_ServiceImpl implements ServiceBooking_Service {

	@Autowired
	private ServiceBookingRepository sbRepo;
	
	@Autowired
	private DeliveryBoyServiceImpl dboy;
	
	@Autowired
	private CustomerServiceImpl custSer;
	
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

	@Override
	public ServiceBooking getServiceBookingById(Long id) {
		
		ServiceBooking booking = sbRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("booking not found"));
	     booking.getCustomer().getCustomerCart().getCartItems().size();
	     booking.getServicesToDone().size();
	     return booking;
	}
	
	@Override
	public ServiceBooking assignDeliveryBoyById(Long bookingid, Long dboyId) {
		DeliveryBoy boy = dboy.getDeliveryBoyById(dboyId);
		ServiceBooking booking = getServiceBookingById(bookingid);
		System.out.println(boy.getScenter().getId());
		System.out.println(booking.getId());
		if(boy.getScenter().getId().equals(booking.getServiceCenter().getId())) {
		booking.addDeliveryBoy(boy);
		return sbRepo.save(booking);
		}
		throw new ResourceNotFoundException("id not match"); 
	}

	@Override
	public ServiceBooking updateServiceStatus(Long bookingid,String Status) {
		ServiceBooking booking = getServiceBookingById(bookingid);
		booking.setStatus(ServiceStatus.valueOf(Status.toUpperCase()));
		return sbRepo.save(booking);
	}

	@Override
	public List<ServiceBooking> allServiceBookingByStatus(String status) {
		List<ServiceBooking> all = sbRepo.findAllBookingsByStatus(ServiceStatus.valueOf(status.toUpperCase()));
		all.forEach(b->b.getCustomer().getCustomerCart().getCartItems().size());
		all.forEach(b->b.getServicesToDone().size());
		return all;
	}

	@Override
	public List<ServiceBooking> allServiceBookByCustomer(Long id) {
		if(custSer.getCustomerById(id)!=null) {
		List<ServiceBooking> all = sbRepo.findAllBookingByCustomerId(id);
		all.forEach(b->b.getCustomer().getCustomerCart().getCartItems().size());
		all.forEach(b->b.getServicesToDone().size());
		return all;
		}
		throw new ResourceNotFoundException("customer not found");
	}

}
