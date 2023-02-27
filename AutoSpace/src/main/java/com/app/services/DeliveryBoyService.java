package com.app.services;

import java.util.List;

import com.app.dto.DeliveryBoyDto;
import com.app.pojos.DeliveryBoy;

public interface DeliveryBoyService {
	
	DeliveryBoy addDeliveryBoy(Long centerId,DeliveryBoyDto newDeliveryBoy);
	
	List<DeliveryBoy> getAllDeliveryBoys();
	
	List<DeliveryBoy> getDeliveryBoysByCenterId(Long Id);
	
	String deleteDeliveryBoy(Long id);
	

}
