package com.consultitnow.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.consultitnow.app.entity.QuotationAgency;

public interface IQuotationAgencyDao extends JpaRepository<QuotationAgency, Long>{

	
	public List<QuotationAgency> findByQuotationId(Long id);
}
