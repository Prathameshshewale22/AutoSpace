package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ServiceCenterDto;
import com.app.pojos.ServiceCenter;
import com.app.services.ServiceCenterServiceImpl;

@RestController
@RequestMapping("/servicecenter")
public class ServiceCenterController {
	@Autowired
	public ServiceCenterServiceImpl SCService;
	
	@PostMapping
	public ServiceCenter AddServiceCenter(@RequestBody ServiceCenterDto newServiceCenter) {
		return SCService.addServiceCenter(newServiceCenter);
	}
	
	@GetMapping
	public List<ServiceCenter> getAllServiceCenters(){
		return SCService.getAllServcieCenters();
	}

}
