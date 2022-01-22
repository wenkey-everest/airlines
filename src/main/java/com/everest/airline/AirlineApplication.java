package com.everest.airline;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirlineApplication {
	public static void main(String[] args) {
		try {
			SpringApplication.run(AirlineApplication.class, args);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
