package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.User;


public interface IUserDao extends JpaRepository<User, Integer>{

	
}
