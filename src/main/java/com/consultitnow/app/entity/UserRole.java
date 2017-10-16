package com.consultitnow.app.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;



@Entity
public class UserRole {

	
	@EmbeddedId
	private UserRoleId primaryKey;
	
	@Column
	private Boolean  authorized;
	
	
	public UserRoleId getPrimaryKey() {
		return primaryKey;
	}


	public void setPrimaryKey(UserRoleId primaryKey) {
		this.primaryKey = primaryKey;
	}


	@Transient
	public User getUser(){
		return getPrimaryKey().getUser();
	}
	
	public void setUser(User user){
		 getPrimaryKey().setUser(user);
	}
	
	
	
	@Transient
	public Role getRole(){
		return getPrimaryKey().getRole();
	}
	
	
	public void setRole(Role role){
		getPrimaryKey().setRole(role);
	}
	
	public Boolean getAuthorized() {
		return authorized;
	}


	public void setAuthorized(Boolean authorized) {
		this.authorized = authorized;
	}



	public UserRole() {
		// TODO Auto-generated constructor stub
		
	
	}

}
