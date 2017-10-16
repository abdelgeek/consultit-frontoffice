package com.consultitnow.app.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Role implements Serializable{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roleId",nullable=false)
	private int roleId;
	
	@Column(name="roleWording")
	private String roleWording;
	
	@Column(name="actived",columnDefinition="boolean default true")
	private Boolean actived;
	
	@OneToMany(mappedBy="primaryKey.role")
	private Collection<UserRole> userRole;
	
	public Collection<UserRole> getUserRole() {
		return userRole;
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


	public Boolean getActived() {
		return actived;
	}


	public void setActived(Boolean actived) {
		this.actived = actived;
	}


	public void setUserRole(Collection<UserRole> userRole) {
		this.userRole = userRole;
	}


	public Role() {
		// TODO Auto-generated constructor stub
	}

}
