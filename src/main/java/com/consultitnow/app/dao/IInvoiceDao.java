package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.Invoice;

public interface IInvoiceDao extends JpaRepository<Invoice, Long> {

}
