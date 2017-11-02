package com.consultitnow.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.ICategoryDao;
import com.consultitnow.app.entity.Category;

@RestController
public class CategoryController {

	@Autowired
	private ICategoryDao categorieDao;
	
	@RequestMapping(value="/findCategories")
	public List<Category> findAll(){
		return categorieDao.findAll();
	}
}
