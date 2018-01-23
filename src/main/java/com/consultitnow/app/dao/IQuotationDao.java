package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.Quotation;

public interface IQuotationDao extends JpaRepository<Quotation, Long> {

}
