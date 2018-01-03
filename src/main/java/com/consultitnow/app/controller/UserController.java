package com.consultitnow.app.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IUserDao;
import com.consultitnow.app.entity.Users;


@RestController
public class UserController {

	@Autowired
	private IUserDao iUser;
	
	@RequestMapping(value="/saveUser")
	public Users save(Users user){
		
		return iUser.save(user);
	}
	
	@RequestMapping(value="/findUsers")
	public List<Users> findAll(){
		return iUser.findAll();
	}
	

}
