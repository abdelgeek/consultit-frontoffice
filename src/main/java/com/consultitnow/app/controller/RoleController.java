package com.consultitnow.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IRoleDao;
import com.consultitnow.app.entity.Role;

@RestController
public class RoleController {

	@Autowired
	private IRoleDao irole;
	
	
	@RequestMapping("/saveRole")
	public void saveRole( Role role){
		irole.save(role);
	}
}
