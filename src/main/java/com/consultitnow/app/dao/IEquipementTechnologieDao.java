package com.consultitnow.app.dao;

import java.util.LinkedList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.EquipmentNature;
import com.consultitnow.app.entity.EquipmentTechnologie;

public interface IEquipementTechnologieDao extends JpaRepository<EquipmentTechnologie, Long> {

	// find equipement type By Approval Type
	public LinkedList<EquipmentTechnologie> findByEquipmentNature(EquipmentNature equipmentNature);
}
