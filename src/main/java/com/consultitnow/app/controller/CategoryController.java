package com.consultitnow.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.ICategoryDao;
import com.consultitnow.app.dao.ICountryDao;
import com.consultitnow.app.entity.Agency;
import com.consultitnow.app.entity.Category;
import com.consultitnow.app.entity.Country;
import com.consultitnow.model.CategoryModel;
import com.consultitnow.model.CategoryResult;

@RestController
public class CategoryController {

	@Autowired
	private ICategoryDao categorieDao;
	@Autowired
	private ICountryDao countryDao;

	//// get categorie by country
	
	 @RequestMapping(value="/findCategorieByCountry",method=RequestMethod.GET)
	 public List<Category> findByCountry(Long idCountry) { 
		 
		 Country country = new Country();
		 country = countryDao.findOne(idCountry);
		 return categorieDao.findByCountry(country); };
	 
}
