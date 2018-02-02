package com.consultitnow.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.ApprovalType;
import com.consultitnow.app.entity.EquipmentNature;

public interface IEquipementNatureDao extends JpaRepository<EquipmentNature, Long> {

	
	public List<EquipmentNature> findByApprovalType(ApprovalType approvalType);
	public EquipmentNature findOne(Long id );
}
