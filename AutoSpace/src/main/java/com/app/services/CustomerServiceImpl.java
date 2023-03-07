package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.CustomerResponse;
import com.app.pojos.Cart;
import com.app.pojos.Customer;
import com.app.pojos.ServiceBooking;
import com.app.repository.CustomerRepository;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	public CustomerRepository custRepo;

	@Override
	public Customer addCustomerDetails(CustomerResponse cust) {
		Customer newCustomer=new Customer(cust.getFirstName(), cust.getLastName(), cust.getEmail(), cust.getPassword(), cust.getMobileNumber(), cust.getAddress());
	    newCustomer.addCart(new Cart());
		return custRepo.save(newCustomer);
	}

	@Override
	public List<Customer> getallCustomers() {
		List<Customer> all=custRepo.findAll();
		all.forEach(c->c.getCustomerCart().getCartItems().size());
		all.forEach(s->s.getBookings().size());
//		all.forEach(s->System.out.println(s.getBookings().toString()));
		all.forEach(b->b.getBookings().get(0).getServicesToDone().size());
//		all.forEach(c->c.getVehicles().size());
		return all;
	}

	@Override
	public Customer getCustomerById(Long id) {
	
		return custRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("invalid Customer id"));
	}
	
	

}
