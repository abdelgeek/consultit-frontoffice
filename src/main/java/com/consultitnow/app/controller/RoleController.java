package com.consultitnow.app.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IRoleDao;
import com.consultitnow.app.entity.Role;

@CrossOrigin
@RestController
public class RoleController {

	@Autowired
	private IRoleDao irole;
	
	@RequestMapping("/saveRole")
	public Role save( Role role){
		return irole.save(role);
	}
	
	@RequestMapping("/findRoles")
	public List<Role> findAll(){
		return irole.findAll();
	}
	
}
