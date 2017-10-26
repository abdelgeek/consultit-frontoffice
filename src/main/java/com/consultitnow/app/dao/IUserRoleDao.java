package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.UsersRole;
import com.consultitnow.app.entity.UserRoleId;

public interface IUserRoleDao extends JpaRepository<UsersRole, UserRoleId> {

}
