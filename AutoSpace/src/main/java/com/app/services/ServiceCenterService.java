package com.app.services;

import java.util.List;

import com.app.dto.ServiceCenterDto;
import com.app.pojos.ServiceCenter;

public interface ServiceCenterService {
	
	ServiceCenter addServiceCenter(ServiceCenterDto newServiceCenter);
	
	List<ServiceCenter> getAllServcieCenters();

}
