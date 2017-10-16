package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.TechnicalRequirement;

public interface ITechnicalRequirementDao extends JpaRepository<TechnicalRequirement, Long> {

}
