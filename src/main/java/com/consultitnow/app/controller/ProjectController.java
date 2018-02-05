package com.consultitnow.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.IProjectDao;
import com.consultitnow.app.entity.Project;

@RestController
@CrossOrigin
public class ProjectController {

	@Autowired
	private IProjectDao projectDao;

	
	@GetMapping("/api/saveProject")
	public Project saveProject(Project project) {
		return projectDao.save(project);
	}

}
