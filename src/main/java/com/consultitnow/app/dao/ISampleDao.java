package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.Sample;

public interface ISampleDao extends JpaRepository<Sample, Long> {

}
