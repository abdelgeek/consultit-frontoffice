package com.consultitnow.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.EquipementType;

public interface IEquipementTypeDao extends JpaRepository<EquipementType, Long> {
	
	//find equipement type By Approval Type
	public List<EquipementType> findByApprovalType(ApprovalType approval);
}
