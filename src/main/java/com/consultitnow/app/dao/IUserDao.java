package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.Users;


public interface IUserDao extends JpaRepository<Users, Integer>{

	
}
