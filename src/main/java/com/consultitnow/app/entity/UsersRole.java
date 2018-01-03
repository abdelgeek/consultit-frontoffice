package com.consultitnow.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;



@Entity
public class UsersRole implements Serializable {

	
	@EmbeddedId
	private UserRoleId primaryKey;
	
	@Column(nullable=false)
	private Boolean  authorized;
	
	
	public UserRoleId getPrimaryKey() {
		return primaryKey;
	}


	public void setPrimaryKey(UserRoleId primaryKey) {
		this.primaryKey = primaryKey;
	}


	@Transient
	public Users getUsers(){
		return getPrimaryKey().getUsers();
	}
	
	public void setUsers(Users users){
		 getPrimaryKey().setUsers(users);
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



	public UsersRole() {
		// TODO Auto-generated constructor stub
		
	
	}


	

	
}
