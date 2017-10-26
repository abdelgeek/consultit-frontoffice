package com.consultitnow.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IUserRoleDao;
import com.consultitnow.app.entity.Users;
import com.consultitnow.app.entity.UsersRole;

@RestController
public class UserRoleController {

	@Autowired
	private IUserRoleDao userRoleDao;
	
	
	
	@RequestMapping(value="addRoleToUser")
	public UsersRole addRoleToUser(UsersRole usersRole ){
		return  userRoleDao.save(usersRole);
	}
	
	

}
