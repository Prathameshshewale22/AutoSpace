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

import com.app.dto.VehicleDto;
import com.app.pojos.Vehicle;
import com.app.services.VehicleServiceImpl;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	@Autowired
	private VehicleServiceImpl vehicleServices;
    
	@PostMapping
	public Vehicle addVehicle(@RequestBody VehicleDto newvehicle) {
		return vehicleServices.addVehicle(newvehicle);	
	}
	
	@GetMapping
	public List<Vehicle> getallVehicles(){
		return vehicleServices.getallVehicle();
	}
	
	@GetMapping("/{customerid}")
	public List<Vehicle> getAllVehicleByCutomerId(Long customerid){
		return vehicleServices.findVehiclesByCustomerId(customerid);
	}
	
	@DeleteMapping("/{id}")
	public String deleteVehicleById(@PathVariable Long id) {
		return vehicleServices.deleteVehicleById(id);
	}
}
