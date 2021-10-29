package com.example.demo.info;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.info.model.City;
import com.example.demo.info.model.Project;
import com.example.demo.info.repository.CityRepository;

@Service
public class InfoService {

	private final CityRepository cityRepository;

	//������ ���� ���
	public InfoService(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	public Project getProjectInfo() {

		Project project = new Project();
		project.projectName = "tomword";
		project.author = "hello - tom";
		project.createdDate = new Date();

		return project;

	}

	public List<City> getCityList(){
		return cityRepository.findList();
	}

}
