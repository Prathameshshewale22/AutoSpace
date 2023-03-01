package com.app.services;

import java.util.List;

import com.app.pojos.Services;

public interface ServicesService {
	
	Services addNewService(Services newService);
	
	List<Services> getAllServices();
	
	Services getServiceById(Long id);
	
	String deleteServiceById(Long id);

}
