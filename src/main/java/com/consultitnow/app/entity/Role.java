package com.consultitnow.app.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Role implements Serializable{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roleId",nullable=false)
	private int roleId;
	
	@Column(name="roleWording")
	private String roleWording;
	
	@Column(name="description")
	private String description;
	
	@Column(name="activated",columnDefinition="boolean default true")
	private Boolean activated;
	
	
	@OneToMany(mappedBy="primaryKey.role")
	private Collection<UsersRole> usersRole;
	
	
	public Collection<UsersRole> getUserRole() {
		return usersRole;
	}

	
	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public String getRoleWording() {
		return roleWording;
	}


	public void setRoleWording(String roleWording) {
		this.roleWording = roleWording;
	}

	
	

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Boolean getactivated() {
		return activated;
	}


	public void setactivated(Boolean activated) {
		this.activated = activated;
	}


	public void setUserRole(Collection<UsersRole> usersRole) {
		this.usersRole = usersRole;
	}


	public Role() {
		// TODO Auto-generated constructor stub
	}

}
