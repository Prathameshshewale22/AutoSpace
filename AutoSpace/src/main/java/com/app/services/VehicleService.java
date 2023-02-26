package com.app.services;

import java.util.List;

import com.app.dto.VehicleDto;
import com.app.pojos.Vehicle;

public interface VehicleService {
	
	Vehicle addVehicle(VehicleDto newVehicle);
	
	List<Vehicle> getallVehicle();
	
	List<Vehicle> findVehiclesByCustomerId(Long id);
	
	String deleteVehicleById(Long id);
	
	Vehicle findVehicleById(Long id);
 
}
