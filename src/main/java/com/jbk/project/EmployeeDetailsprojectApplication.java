package com.jbk.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jbk.project.service.EmployeeService;

@SpringBootApplication
public class EmployeeDetailsprojectApplication {

	@Autowired
	EmployeeService service;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDetailsprojectApplication.class, args);
	}


}