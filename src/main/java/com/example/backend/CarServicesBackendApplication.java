package com.example.backend;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarServicesBackendApplication {
	private static final Logger logger = LogManager.getLogger(CarServicesBackendApplication.class);
	CarServicesBackendApplication(){}
	public static void main(String[] args) {
		CarServicesBackendApplication.logger.info("[REGISTER]", 1);
		SpringApplication.run(CarServicesBackendApplication.class, args);
	}

}
