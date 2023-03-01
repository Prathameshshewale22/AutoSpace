package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Services;
import com.app.repository.ServicesRepository;
@Service
@Transactional
public class ServicesServiceImpl implements ServicesService{
	@Autowired
	private ServicesRepository serRepo;

	@Override
	public Services addNewService(Services newService) {		
		return serRepo.save(newService);
	}

	@Override
	public List<Services> getAllServices() {
		
		return serRepo.findAll();
	}

	@Override
	public Services getServiceById(Long id) {
		
		return serRepo.findById(id).orElseThrow();
	}

	@Override
	public String deleteServiceById(Long id) {
		if(serRepo.existsById(id)) {
			serRepo.deleteById(id);
			return "deleted!!";
		}
		return "not deleted";
	}

}
