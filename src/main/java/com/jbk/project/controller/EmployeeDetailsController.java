package com.jbk.project.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.project.entity.Country;
import com.jbk.project.entity.Employee;
import com.jbk.project.entity.Registration;
import com.jbk.project.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class EmployeeDetailsController {

	@Autowired
	EmployeeService service;

	@PostMapping(value = "/loginCheck")
	public HashMap<String, Object> loginCheck(@RequestBody Registration registration) {
		return service.checkLogin(registration.getEmail(), registration.getPassword());
	}

	@GetMapping(value = "/getAllEmployee")
	public List<Employee> getAllEmployee() {

		return service.getAllEmployee();
	}

	@GetMapping(value = "/getEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable int id) {

		return service.getEmployeeById(id);
	}

	@GetMapping(value = "/getAllCountry")
	public List<Country> getAllCountry() {

		return service.getAllCountry();
	}

	@PostMapping(value = "/addEmployee")
	public String addEmployee(@RequestBody Employee employee) {

		return service.addEmployee(employee);
	}

	@PutMapping(value = "/updateEmployee")
	public String updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}

	@DeleteMapping(value = "/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return service.deleteEmployeeById(id);
	}

	@GetMapping(value = "/changeStatus/{id}")
	public String changeStatus(@PathVariable int id) {

		return service.changeStatus(id);
	}

	@GetMapping("/hi")
	public String display() {
		return "hi";
	}
}
