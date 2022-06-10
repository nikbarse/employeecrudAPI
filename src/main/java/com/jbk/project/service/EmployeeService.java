package com.jbk.project.service;

import java.util.HashMap;
import java.util.List;

import com.jbk.project.entity.Country;
import com.jbk.project.entity.Employee;




public interface EmployeeService {

	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(int id);
	public Employee getEmployeeByName(String name);
	public List<Employee> getAllEmployeeByStatus(String status);
	public String addEmployee(Employee employee);
	public String addCountry(Country country);
	public List<Country> getAllCountry();
	public Country getCountryById(int cid);
	public Country getCountryByName(String cname);
	public String deleteCountryByName(String cname);
	public String deleteEmployeeById(int id);
	public List<Employee> getAllListBeforeToday ();
	public String updateCountry(Country country);
	public String updateEmployee(Employee employee);
	public HashMap<String,Object> checkLogin (String email, String password);
	public String changeStatus (int id);

	
	
	
	public void readExcel();
}
