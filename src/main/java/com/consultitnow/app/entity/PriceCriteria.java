package com.consultitnow.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PriceCriteria implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String code;
	
	@JsonIgnore
	@OneToMany(mappedBy="priceCriteria")
	private List<CategoryPrice>  categoryPrices;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<CategoryPrice> getCategoryPrices() {
		return categoryPrices;
	}

	public void setCategoryPrices(List<CategoryPrice> categoryPrices) {
		this.categoryPrices = categoryPrices;
	}
	
	
}
