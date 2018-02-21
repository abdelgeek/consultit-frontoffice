package com.consultitnow.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class PriceCriteria implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Name;
	
	@OneToMany(mappedBy="priceCriteria")
	private List<Agency> agencies;
	
	public PriceCriteria() {
		// TODO Auto-generated constructor stub
	}

}
