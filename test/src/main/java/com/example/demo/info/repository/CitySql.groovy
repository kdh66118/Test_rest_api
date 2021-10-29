package com.example.demo.info.repository

class CitySql {
	public static final String SELECT = """
						SELECT ID, NAME, COUNTRYCODE, DISTRICT, POPULATION FROM CITY WHERE 1=1
						""";
	public static final String COUNTRY_CODE_CONDITION = """
						AND COUNTRYCODE = :countryCode
						""";
	public static final String POPULATION_CONDITION ="""
						AND POPULATION >= :population
						""";

}
