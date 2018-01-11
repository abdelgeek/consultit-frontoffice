package com.consultitnow.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.EquipementNature;

public interface IEquipementNatureDao extends JpaRepository<EquipementNature, Long> {

	
	public List<EquipementNature> findByApprovalType(ApprovalType approvalType);
	public EquipementNature findOne(Long id );
}
