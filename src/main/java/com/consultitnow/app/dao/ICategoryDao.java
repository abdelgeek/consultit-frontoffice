package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.Category;

public interface ICategoryDao extends JpaRepository<Category, Long> {

	public Category findById(Long id);
	public Category findByCategoryName(String categoryName);
}
