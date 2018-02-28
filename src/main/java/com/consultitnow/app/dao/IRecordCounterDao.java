package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.RecordCounter;

public interface IRecordCounterDao extends JpaRepository<RecordCounter, Long>{

}
