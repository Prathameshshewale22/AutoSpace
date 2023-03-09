package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.CountData;
import com.app.pojos.Admin;
import com.app.repository.AdminRepository;
import com.app.repository.CustomerRepository;
import com.app.repository.DeliveryBoyRepository;
import com.app.repository.ManagerRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private CustomerRepository cust;
	
	@Autowired
	private DeliveryBoyRepository dboy;
	
	@Autowired
	private ManagerRepository manager;
	
	@Override
	public Admin addAdmin(Admin newAdmin) {
		if(newAdmin!=null) {
			return adminRepo.save(newAdmin);
		}
		throw new ResourceNotFoundException("null object");
	}

	@Override
	public List<Admin> getAllAdmins() {
		
		return adminRepo.findAll();
	}

	@Override
	public CountData getAllCounts() {
	      long customers = cust.count();
	      long boys = dboy.count();
	      long managers = manager.count();
	     return new CountData(managers, customers, boys);
	}

}
