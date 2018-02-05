package com.consultitnow.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.ICategoryDao;
import com.consultitnow.app.dao.ICountryDao;
import com.consultitnow.app.entity.Category;
import com.consultitnow.app.entity.Country;

@CrossOrigin
@RestController
public class CategoryController {

	@Autowired
	private ICategoryDao categorieDao;
	@Autowired
	private ICountryDao countryDao;

	// get categorie by country

	@GetMapping(value = "/api/findCategorieByCountry")
	public List<Category> findByCountry(Long idCountry) {

		Country country = new Country();
		country = countryDao.findOne(idCountry);
		return categorieDao.findByCountry(country);
	};
	
	@GetMapping(value = "/api/findOneCategory")
	public Category findOne(Long categoryId) {

		return categorieDao.findOne(categoryId);
	};

}
