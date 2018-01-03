package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.ApprovalType;

public interface IApprovalType extends JpaRepository<ApprovalType, Long>{
	
	public ApprovalType findByName(String approvalName);
}
