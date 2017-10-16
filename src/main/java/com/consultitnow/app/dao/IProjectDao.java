package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.Project;


public interface IProjectDao extends JpaRepository<Project,Long> {

}
