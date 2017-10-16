package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.Country;

public interface ICountryDao extends JpaRepository<Country, Long>{

}
