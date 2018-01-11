package com.consultitnow.app.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.EquipementNature;
import com.consultitnow.app.entity.EquipementTechnologie;

public interface IEquipementTechnologieDao extends JpaRepository<EquipementTechnologie, Long> {
	
	//find equipement type By Approval Type
	public LinkedList<EquipementTechnologie> findByEquipementNature(EquipementNature equipementNature);
}
