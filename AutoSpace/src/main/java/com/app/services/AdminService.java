package com.app.services;

import java.util.List;

import com.app.pojos.Admin;

public interface AdminService {
	
	Admin addAdmin(Admin newAdmin);
	
	List<Admin> getAllAdmins();

}
