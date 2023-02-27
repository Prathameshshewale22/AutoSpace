package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ManagerDto;
import com.app.pojos.Manager;
import com.app.services.ManagerServiceImpl;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	private ManagerServiceImpl managerService;
	
	@PostMapping("/{id}")
	public Manager addManager(@PathVariable Long id, @RequestBody ManagerDto manager) {
		return managerService.addManager(id,manager);
	}
	
	@GetMapping
	public List<Manager> getAllManager(){
		return managerService.getAllManagers();
	}
	
	@DeleteMapping
	public String deleteManager(@PathVariable Long id) {
		return managerService.deleteManager(id);
	}
	

}
