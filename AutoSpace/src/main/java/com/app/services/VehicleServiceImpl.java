package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.VehicleDto;
import com.app.pojos.Customer;
import com.app.pojos.Vehicle;
import com.app.repository.CustomerRepository;
import com.app.repository.VehicleRepository;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
  
	@Autowired
	public VehicleRepository vehicle;
	@Autowired
	public CustomerService customer;
	
	@Override
	public Vehicle addVehicle(VehicleDto newVehicle) {
		Vehicle nVehicle=new Vehicle(newVehicle.getVehicleNumber(), newVehicle.getCompany(), newVehicle.getModel());
	    Customer foundCustomer=customer.getCustomerById(newVehicle.getCustomerId());
		foundCustomer.addVehicle(nVehicle);
		return vehicle.save(nVehicle);
	}

	@Override
	public List<Vehicle> getallVehicle() {
	
		return vehicle.findAll();
	}

	@Override
	public List<Vehicle> findVehiclesByCustomerId(Long id) {
		
		return vehicle.findAllByCustomerId(id);
	}

	@Override
	public Vehicle findVehicleById(Long id) {
		
		return vehicle.findById(id).orElseThrow();
	}
	
	@Override
	public String deleteVehicleById(Long id) {
		System.out.println(id);
//		Vehicle foundVehicle=findVehicleById(id);
//		Customer cust=foundVehicle.getCustomer();
//		cust.getVehicles().remove(id);
		if(vehicle.existsById(id)) {
		vehicle.deleteById(id);
		return "deleted !!";
		}
		else
			return "not deleted";
	}

	
  
	
}
