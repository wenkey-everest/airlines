package com.everest.airline;

import com.everest.airline.database.DataParser;
import com.everest.airline.services.SearchService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineApplication.class, args);
		DataParser dataParser = new DataParser();
		dataParser.testFileSystem();
	}

}
