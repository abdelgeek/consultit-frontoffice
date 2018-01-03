package com.consultitnow.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.Role;

public interface IRoleDao extends JpaRepository<Role, Integer> {

}
