package com.consultitnow.app.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "UserType")
public class Users implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId", nullable = false)
	private Integer userId;

	@Column(name = "username", nullable = false)
	private String userName;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "isConfirm", nullable = false, columnDefinition = "boolean default false")
	private Boolean isConfirm;

	@Column(name = "actived", columnDefinition = "boolean default true")
	private Boolean actived;

	@Column(name = "email", nullable = false)
	private String email;

	@OneToMany(mappedBy = "primaryKey.users", cascade = CascadeType.ALL)
	private Collection<UsersRole> usersRoles;

	@Column(name = "firstName", nullable = false)
	private String firstName;
	
	@Column(name = "lastName", nullable = false)
	private String lastName;

	
	@Column(name = "mobile", nullable = false)
	private String mobile;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Users() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsConfirm() {
		return isConfirm;
	}

	public void setIsConfirm(Boolean isConfirm) {
		this.isConfirm = isConfirm;
	}

	public Boolean getActived() {
		return actived;
	}

	public void setActived(Boolean actived) {
		this.actived = actived;
	}

	public Collection<UsersRole> getUserRole() {
		return usersRoles;
	}

	public void setUserRole(Collection<UsersRole> usersRoles) {
		this.usersRoles = usersRoles;
	}

}
