package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.InternalAgent;

public interface IInternalAgentDao extends JpaRepository<InternalAgent, Long> {

}
