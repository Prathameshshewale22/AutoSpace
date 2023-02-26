package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CustomerResponse;
import com.app.pojos.Customer;
import com.app.services.CustomerServiceImpl;



@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	public CustomerServiceImpl custService;
	
	@GetMapping
	public List<Customer> getAllCustomers(){
		return custService.getallCustomers();
	}
	
	@PostMapping
	public Customer addCustomer(@RequestBody CustomerResponse cust) {
		return custService.addCustomerDetails(cust);
	}
}
