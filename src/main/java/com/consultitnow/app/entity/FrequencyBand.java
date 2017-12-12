package com.consultitnow.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class FrequencyBand implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer minFrequency;
	private Integer maxFrequency;
	private  String unit;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getMinFrequency() {
		return minFrequency;
	}
	public void setMinFrequency(Integer minFrequency) {
		this.minFrequency = minFrequency;
	}
	public Integer getMaxFrequency() {
		return maxFrequency;
	}
	public void setMaxFrequency(Integer maxFrequency) {
		this.maxFrequency = maxFrequency;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public FrequencyBand(Long id, Integer minFrequency, Integer maxFrequency, String unit) {
		super();
		this.id = id;
		this.minFrequency = minFrequency;
		this.maxFrequency = maxFrequency;
		this.unit = unit;
	}
	public FrequencyBand() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
