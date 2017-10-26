package com.consultitnow.app.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Quotation implements Serializable{

	@Id
	private Long id;
	private Date Quotationdate;
	private Boolean isValidate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Project project;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getQuotationdate() {
		return Quotationdate;
	}

	public void setQuotationdate(Date quotationdate) {
		Quotationdate = quotationdate;
	}

	public Boolean getIsValidate() {
		return isValidate;
	}

	public void setIsValidate(Boolean isValidate) {
		this.isValidate = isValidate;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Quotation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
