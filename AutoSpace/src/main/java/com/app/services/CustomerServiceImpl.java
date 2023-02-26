package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.CustomerResponse;
import com.app.pojos.Customer;
import com.app.repository.CustomerRepository;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	public CustomerRepository custRepo;

	@Override
	public Customer addCustomerDetails(CustomerResponse cust) {
		Customer newCustomer=new Customer(cust.getFirstName(), cust.getLastName(), cust.getEmail(), cust.getPassword(), cust.getMobileNumber(), cust.getAddress());
	
		return custRepo.save(newCustomer);
	}

	@Override
	public List<Customer> getallCustomers() {
		
		return custRepo.findAll();
	}
	
	

}
