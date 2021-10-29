package com.example.demo.info;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.info.model.City;
import com.example.demo.info.model.Project;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("info")
public class InfoController {

	private InfoService infoService;

	@Autowired
	public InfoController(InfoService infoService) {
		this.infoService = infoService;
	}

	@GetMapping("Project")
	public Object projectInfo() {
		log.debug("/info start");

//		return "Project name is noting.";
		Project project = infoService.getProjectInfo();
		return project;
	}

	@GetMapping("custom")
	public String customJson() {
		JsonObject jo = new JsonObject();

		jo.addProperty("projectName", "preword");
		jo.addProperty("author", "hello-tom");
		jo.addProperty("createdDate", new Date().toString());


		JsonArray ja = new JsonArray();
		for(int i=0; i<5; i++) {
			JsonObject jObj = new JsonObject();
			jObj.addProperty("prop"+i, i);
			ja.add(jObj);
		}

		jo.add("follower", ja);

		return jo.toString();
	}


	@GetMapping("cityList")
	public Object cityList() {
		log.debug("/cityList start");

		List<City> cityList = infoService.getCityList();

		return cityList;
	}

	@GetMapping("cityListByCode")
	public Object cityByCountryCode(@RequestParam("countryCode") String ctCode,
			@RequestParam( value = "population", required = false, defaultValue = "0") int population) {

		log.debug("countryCode = {}, population = {}", ctCode, population);

		List<City> cityList = infoService.findCityByCodeAndPopulation(ctCode, population);

		return cityList;
	}

//	@GetMapping("cityAdd/{name}/{countryCode}/{district}/{population}")
//	public Object cityAdd(@PathVariable(value="name") String name
//			, @PathVariable(value="countryCode") String ctCode
//			, @PathVariable(value="district") String district
//			, @PathVariable(value="population") int population)  {
//
//		log.debug("name = {}, countryCode = {}, district = {}, population = {}", name, ctCode, district, population);
//
//		return "ok";
//	}

	@PostMapping(value="cityAdd")
	public ResponseEntity<City> cityAdd(@RequestBody City city) {

		try {
			log.debug("city = {}", city.toString());
			return new ResponseEntity<>(infoService.insert(city), HttpStatus.OK);

		} catch (Exception e) {
			log.error(e.toString());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(value="cityEdit")
	public ResponseEntity<String> cityEdit(@RequestBody City city){
		try {
			log.debug("city = {}", city.toString());
			Integer updatedCnt = infoService.updateById(city);

			return new ResponseEntity<>(String.format("%d updated", updatedCnt), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.toString());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ResponseBody
	@PostMapping(value="cityDelete")
	public ResponseEntity<String> cityDelete(@RequestParam(value="id") Integer id){
		try {
			log.debug("city = {}", id);
			Integer deletedCnt  = infoService.deleteById(id);

			return new ResponseEntity<>(String.format("%d deleted", deletedCnt), HttpStatus.OK);
			} catch (Exception e) {
			log.error(e.toString());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
