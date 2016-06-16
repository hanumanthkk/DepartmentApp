package com.example;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DepartmentAppApplication {

	static final Logger logger = LogManager.getLogger(DepartmentAppApplication.class.getName());
	public static void main(String[] args) {
		logger.info("entered application");
		SpringApplication.run(DepartmentAppApplication.class, args);
	}
}
