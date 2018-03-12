package com.consultitnow.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.QuotationFrequencies;

public interface IQuotationFrequenciesDao extends JpaRepository<QuotationFrequencies, Long> {

	public List<QuotationFrequencies> findByQuotationId(Long id);
}
