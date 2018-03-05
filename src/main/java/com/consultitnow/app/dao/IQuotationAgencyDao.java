package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.QuotationAgency;

public interface IQuotationAgencyDao extends JpaRepository<QuotationAgency, Long>{

}
