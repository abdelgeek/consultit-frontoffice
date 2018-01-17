package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.EquipementType;

public interface IEquipementTypeDao extends JpaRepository<EquipementType, Long> {

}
