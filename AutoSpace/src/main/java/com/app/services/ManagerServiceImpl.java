package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ManagerDto;
import com.app.pojos.Manager;
import com.app.pojos.ServiceCenter;
import com.app.repository.ManagerRepository;
import com.app.repository.ServiceCenterRepository;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{
 
	@Autowired
	public ManagerRepository managerRepo;
	
	@Autowired
	public ServiceCenterServiceImpl center;
	
	
	@Override
	public Manager addManager(Long serviceCenterid,ManagerDto newManager) {
		ServiceCenter serviceCenter = center.findCenterById(serviceCenterid);
		Manager nManager=new Manager(newManager.getFirstName(), newManager.getLastName(), newManager.getEmail(), newManager.getPassword(), newManager.getMobileNumber());
		serviceCenter.addManager(nManager);
		return managerRepo.save(nManager);
	}

	@Override
	public List<Manager> getAllManagers() {
	
		return managerRepo.findAll();
	}

	@Override
	public String deleteManager(Long id) {
		if(managerRepo.existsById(id)) {
			managerRepo.deleteById(id);
			return "Manager Deleted!!";
		}
		return "manager not Deleted";
		
	}

	@Override
	public Manager updateManager(ManagerDto UpdatedManager) {
		
		return null;
	}

	@Override
	public Manager findManagerById(Long id) {
	
		return managerRepo.findById(id).orElseThrow();
	}

}
