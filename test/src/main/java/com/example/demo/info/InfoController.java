package com.example.demo.info;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.info.model.Project;
import com.google.gson.JsonObject;

@RestController
public class InfoController {

	@GetMapping("/info")
	public Object projectInfo() {
//		return "Project name is noting.";
		Project project = new Project();
		project.projectName = "preword";
		project.author = "hello-tom";
		project.createdDate = new Date();

		return project;
	}

	public String custimJson() {
		JsonObject jo = new JsonObject();

		jo.addProperty("projectName", "preword");
	}
}
