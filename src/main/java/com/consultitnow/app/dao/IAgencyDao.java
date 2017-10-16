package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.Agency;

public interface IAgencyDao extends JpaRepository<Agency, Long> {

}
