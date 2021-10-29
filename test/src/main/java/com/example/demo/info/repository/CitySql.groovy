package com.example.demo.info.repository

class CitySql {
	public static final String SELECT = """
						SELECT ID, NAME, COUNTRYCODE, DISTRICT, POPULATION FROM CITY
						WHERE 1=1
						""";
	public static final String COUNTRY_CODE_CONDITION = """
						AND COUNTRYCODE = :countryCode
						""";
	public static final String POPULATION_CONDITION ="""
						AND POPULATION >= :population
						""";
	public static final String INSERT = """
						INSERT INTO CITY (NAME, COUNTRYCODE, DISTRICT, POPULATION)
						VALUES(:name, :countryCode, :district, :population)
						""";
	public static final String UPDATE = """
						UPDATE CITY
						  SET NAME = :name,
							  COUNTRYCODE = :countryCode,
						      DISTRICT = :district,
						      POPULATION = :population
						WHERE 1=1
						""";
	public static final String ID_CONDITION = """
						AND ID = :id
						""";
	public static final String DELETE = """
						DELETE FROM CITY WHERE 1=1
						""";
}
