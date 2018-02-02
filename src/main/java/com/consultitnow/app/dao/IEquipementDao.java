package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.Equipment;

public interface IEquipementDao extends JpaRepository<Equipment, Long>{

}
