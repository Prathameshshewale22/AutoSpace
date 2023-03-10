package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CountData;
import com.app.pojos.Admin;
import com.app.services.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {
	
	@Autowired
	private AdminServiceImpl admin;
	
	@PostMapping
	public Admin addAdmin(@RequestBody Admin newAdmin) {
		return admin.addAdmin(newAdmin);
	}
	
	@GetMapping
	public List<Admin> getAllAdmin(){
		return admin.getAllAdmins();
	}
	
	@GetMapping("/dashboard/counts")
	public CountData getCounts() {
		return admin.getAllCounts();
	}
	
	@PostMapping("/login")
	public Admin login(String email,String password) {
		return admin.adminLogin(email, password);
	}
}
