package com.consultitnow.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.Quotation;

public interface IQuotationDao extends JpaRepository<Quotation, Long> {
			
	public List<Quotation> findByStatusOrderByDate(Integer status);
}
