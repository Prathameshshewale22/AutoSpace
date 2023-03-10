package com.app.services;

import java.io.Console;
import java.util.List;

import org.aspectj.weaver.NameMangler;
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
<<<<<<< HEAD
		System.out.println(UpdatedManager);
		Manager foundManager=managerRepo.findById((long) UpdatedManager.getId()).orElseThrow();
=======
		Manager foundManager=managerRepo.findById(Long.parseLong(UpdatedManager.getId())).orElseThrow();
>>>>>>> 6d7c96b938da66a954faaa634523026791fa2528
		System.out.println(foundManager.getPassword());
		foundManager.setFirstName(UpdatedManager.getFirstName());
		foundManager.setLastName(UpdatedManager.getLastName());
		foundManager.setEmail(UpdatedManager.getEmail());
		foundManager.setMobileNumber(UpdatedManager.getMobileNumber());
		foundManager.setPassword(foundManager.getPassword());
		System.out.println(foundManager.getPassword());
		return managerRepo.save(foundManager);
	}

	@Override
	public Manager findManagerById(Long id) {
	
		return managerRepo.findById(id).orElseThrow();
	}

}
