package com.example.demo.info;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.demo.info.model.Project;

@Service
public class InfoService {

	public Project getProjectInfo() {

		Project project = new Project();
		project.projectName = "tomword";
		project.author = "hello - tom";
		project.createdDate = new Date();

		return project;

	}
}
