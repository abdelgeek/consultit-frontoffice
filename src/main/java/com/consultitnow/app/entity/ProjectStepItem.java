package com.consultitnow.app.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProjectStepItem implements Serializable{

	@Id
	private Long id;
	
	private String  ProjectStepItemWording;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private ProjectStep projectStep;
}
