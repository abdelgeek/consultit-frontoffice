package com.consultitnow.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.EquipmentType;

public interface IEquipementTypeDao extends JpaRepository<EquipmentType, Long> {
	

	
	public List<EquipmentType> findAllByOrderByName();
}
