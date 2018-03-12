package com.consultitnow.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.QuotationAgency;
import com.consultitnow.app.entity.QuotationTechnologies;

public interface IQuotationTechnologiesDao extends JpaRepository<QuotationTechnologies, Long>{
	
	
	public List<QuotationTechnologies> findByQuotationId(Long id);
}
