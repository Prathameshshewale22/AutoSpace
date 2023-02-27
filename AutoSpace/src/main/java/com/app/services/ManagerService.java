package com.app.services;

import java.util.List;

import com.app.dto.ManagerDto;
import com.app.pojos.Manager;

public interface ManagerService {
	
	Manager addManager(Long id,ManagerDto newManager);
	
	List<Manager> getAllManagers();
	
	String deleteManager(Long id);
	
	Manager updateManager(ManagerDto UpdatedManager);
	
	Manager findManagerById(Long id);

}
