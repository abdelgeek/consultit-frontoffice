package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.Category;

public interface ICategoryDao extends JpaRepository<Category, Long> {

}
