package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.ProjectStep;


public interface IProjectStepDao extends JpaRepository<ProjectStep, Long> {

}
