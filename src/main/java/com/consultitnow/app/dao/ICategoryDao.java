package com.consultitnow.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.consultitnow.app.entity.Category;
import com.consultitnow.app.entity.Country;

public interface ICategoryDao extends JpaRepository<Category, Long> {

	//get categorie by country
	public List<Category> findByCountry(Country country);
	
}
