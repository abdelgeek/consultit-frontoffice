package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.Attachment;

public interface IattachmentDao extends JpaRepository<Attachment, Long>{

}
