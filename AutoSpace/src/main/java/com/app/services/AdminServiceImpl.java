package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.pojos.Admin;
import com.app.repository.AdminRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepo;
	
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

}
