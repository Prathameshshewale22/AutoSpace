package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.DeliveryBoyDto;
import com.app.pojos.DeliveryBoy;
import com.app.pojos.ServiceCenter;
import com.app.repository.DeliveryBoyRepository;
@Service
@Transactional
public class DeliveryBoyServiceImpl implements DeliveryBoyService{
	
	@Autowired
	private DeliveryBoyRepository deliveryBoyRepo;
	
	@Autowired
	private ServiceCenterServiceImpl serviceCenter;

	@Override
	public DeliveryBoy addDeliveryBoy(Long centerId,DeliveryBoyDto newDeliveryBoy) {
		ServiceCenter center=serviceCenter.findCenterById(centerId);
		DeliveryBoy nDeliveryBoy=new DeliveryBoy(newDeliveryBoy.getFirstName(), newDeliveryBoy.getLastName(), newDeliveryBoy.getEmail(), newDeliveryBoy.getPassword(),newDeliveryBoy.getMobileNumber());
		center.addDeliveryBoy(nDeliveryBoy);
		return deliveryBoyRepo.save(nDeliveryBoy);
	}

	@Override
	public List<DeliveryBoy> getAllDeliveryBoys() {		
		return deliveryBoyRepo.findAll();
	}

	@Override
	public List<DeliveryBoy> getDeliveryBoysByCenterId(Long Id) {
		return deliveryBoyRepo.findAllDeliveryBoysByCenterId(Id);
	}

	@Override
	public String deleteDeliveryBoy(Long id) {
		if(deliveryBoyRepo.existsById(id)) {
			 deliveryBoyRepo.deleteById(id);
			 return "deleted!!";
		}
		return "Not deleted";
		
	}

}
