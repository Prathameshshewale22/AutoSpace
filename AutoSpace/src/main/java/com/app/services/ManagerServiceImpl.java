package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ManagerDto;
import com.app.pojos.Manager;
import com.app.repository.ManagerRepository;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{
 
	@Autowired
	public ManagerRepository managerRepo;
	
	
	@Override
	public Manager addManager(ManagerDto newManager) {
		Manager nManager=new Manager(newManager.getFirstName(), newManager.getLastName(), newManager.getEmail(), newManager.getPassword(), newManager.getMobileNumber());
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

}
