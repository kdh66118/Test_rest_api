package com.example.demo.info;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.info.model.City;
import com.example.demo.info.model.Project;
import com.example.demo.info.repository.CityRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InfoService {

	private final CityRepository cityRepository;

	//积己磊 林涝 规过
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

	public List<City> findCityByCodeAndPopulation(String countryCode, int population) {
		log.debug("countryCode = {}, population = {}", countryCode, population);
		return this.cityRepository.findByCountryCodeAndPopulation(countryCode, population);
	}

	public City insert(City city) {
		return this.cityRepository.insert(city);
	}

	public Integer updateById(City city) {
		log.debug("city id = {}", city.getId());
		return cityRepository.updateById(city);
	}

	public Integer deleteById(Integer id) {
		log.debug("city id = {}", id);
		return cityRepository.deleteById(id);
	}

}
