package com.consultitnow.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.Country;
import com.consultitnow.app.entity.EquipementType;

public interface ICountryDao extends JpaRepository<Country, Long>{
	
	//get a country that approve an equipement type
	//public List<Country> findByAgenciesEquipementTypes(EquipementType equipementType);
	
	
}
