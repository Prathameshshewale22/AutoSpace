package com.app.services;

import java.util.List;

import com.app.dto.CustomerResponse;
import com.app.pojos.Customer;

import com.app.pojos.Customer;

public interface CustomerService {
	
	Customer addCustomerDetails(CustomerResponse cust);
	
	List<Customer> getallCustomers();

	Customer getCustomerById(Long id);
}
