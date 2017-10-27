package com.consultitnow.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.Country;

public interface ICountryDao extends JpaRepository<Country, Long>{

	
	//get one country by name
	public Country findByCountryName(String CountryName);
	
	
	//get all active country
	public List<Country> findByIsActive(Boolean isActive);
}
