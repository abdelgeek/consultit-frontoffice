package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.FrequencyBand;

public interface IfrequencyDao extends JpaRepository<FrequencyBand, Long>{

}
