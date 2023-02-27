package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ServiceCenterDto;
import com.app.pojos.Manager;
import com.app.pojos.ServiceCenter;
import com.app.repository.ServiceCenterRepository;
@Service
@Transactional
public class ServiceCenterServiceImpl implements ServiceCenterService{
	@Autowired
	private ServiceCenterRepository SCRepo;
	

	@Override
	public ServiceCenter addServiceCenter(ServiceCenterDto newServiceCenter) {
		ServiceCenter nServiceCenter=new ServiceCenter(newServiceCenter.getCenterName(), newServiceCenter.getCenterAddress(), newServiceCenter.getCity(), newServiceCenter.getZipcode(), newServiceCenter.getContactNumber(), newServiceCenter.getEmail());
		return SCRepo.save(nServiceCenter);
	}

	@Override
	public List<ServiceCenter> getAllServcieCenters() {
		List<ServiceCenter> all = SCRepo.findAll();
		all.forEach(s->s.getBookings().size());
		return all;
	}

	@Override
	public ServiceCenter findCenterById(Long id) {
		
		return SCRepo.findById(id).orElseThrow();
	}

	

}
