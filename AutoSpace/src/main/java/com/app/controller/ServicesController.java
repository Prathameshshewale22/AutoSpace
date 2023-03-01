package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Services;
import com.app.services.ServicesServiceImpl;

@RestController
@RequestMapping("/service")
public class ServicesController {

	@Autowired
	private ServicesServiceImpl service;
	
	@GetMapping
	public List<Services> getAllServices(){
		return service.getAllServices();
	}
	
	@PostMapping
	public Services addService(@RequestBody Services newService) {
		return service.addNewService(newService);
	}
	
	@DeleteMapping
	public String deleteService(@PathVariable Long id) {
		return service.deleteServiceById(id);
	}
}
