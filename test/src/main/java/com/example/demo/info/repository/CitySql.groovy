package com.example.demo.info.repository

class CitySql {
		public static final String SELECT = """
						SELECT ID, NAME, COUNTRYCODE, DISTRICT, POPULATION FROM CITY LIMIT 1000;
						""";

}
