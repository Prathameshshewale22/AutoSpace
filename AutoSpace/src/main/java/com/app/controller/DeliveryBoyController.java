package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DeliveryBoyDto;
import com.app.pojos.DeliveryBoy;
import com.app.services.DeliveryBoyServiceImpl;

@RestController
@RequestMapping("/deliveryboy")
@CrossOrigin(origins = "*")
public class DeliveryBoyController {
  
	@Autowired
	private DeliveryBoyServiceImpl dboyser;
	
	@GetMapping
	public List<DeliveryBoy> getAllDeliveryBoys(){
		return dboyser.getAllDeliveryBoys();
	}
	
	@PostMapping("/{centerid}")
	public DeliveryBoy addDeliveryBoy(@PathVariable Long centerid,@RequestBody DeliveryBoyDto newDeliveryBoy) {
		return dboyser.addDeliveryBoy(centerid, newDeliveryBoy);
	}
	
	@DeleteMapping("/{id}")
	public String deleteDeliveryBoy(@PathVariable Long id) {
		return dboyser.deleteDeliveryBoy(id);
	}
	
	@GetMapping("/{id}")
	public List<DeliveryBoy> getAllDeliveryBoysByCenterId(@PathVariable Long id){
		return dboyser.getDeliveryBoysByCenterId(id);
	}
}
