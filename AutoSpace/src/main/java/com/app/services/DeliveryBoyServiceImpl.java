package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
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
		List<DeliveryBoy> all=deliveryBoyRepo.findAll();
		all.forEach(s->s.getScenter().deliveryBoys.size());
		return all;
	}

	@Override
	public List<DeliveryBoy> getDeliveryBoysByCenterId(Long Id) {
		return deliveryBoyRepo.findAllDeliveryBoysByScenterId(Id);
	}

	@Override
	public String deleteDeliveryBoy(Long id) {
		if(deliveryBoyRepo.existsById(id)) {
			 deliveryBoyRepo.deleteById(id);
			 return "deleted!!";
		}
		return "Not deleted";	
	}

	@Override
	public DeliveryBoy getDeliveryBoyById(Long id) {
	
		return deliveryBoyRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("not found"));
	}
	
	

}
