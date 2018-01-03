package com.consultitnow.app.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class UserRoleId implements Serializable {

	@ManyToOne(cascade = CascadeType.ALL)
	private Users users;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Role role;
	
	public UserRoleId() {
		// TODO Auto-generated constructor stub
	}

	

	public Users getUsers() {
		return users;
	}



	public void setUsers(Users users) {
		this.users = users;
	}



	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserRoleId(Users users, Role role) {
		super();
		this.users = users;
		this.role = role;
	}
	
	

}
