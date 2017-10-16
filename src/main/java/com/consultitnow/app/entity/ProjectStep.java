package com.consultitnow.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProjectStep {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String ProjectStepWording;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectStepWording() {
		return ProjectStepWording;
	}
	public void setProjectStepWording(String projectStepWording) {
		ProjectStepWording = projectStepWording;
	}
	public ProjectStep() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
