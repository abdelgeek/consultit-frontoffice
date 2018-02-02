package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.PurchaseOrder;

public interface IPurchaseOrderDao extends JpaRepository<PurchaseOrder, Long>{

}
