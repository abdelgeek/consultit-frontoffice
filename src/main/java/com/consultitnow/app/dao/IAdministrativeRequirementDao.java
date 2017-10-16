package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.AdministrativeRequirements;

public interface IAdministrativeRequirementDao extends JpaRepository<AdministrativeRequirements, Long>{

}
