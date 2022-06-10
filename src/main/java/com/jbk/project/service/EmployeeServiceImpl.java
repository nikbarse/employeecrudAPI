package com.jbk.project.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jbk.project.dao.EmployeeDao;
import com.jbk.project.entity.Country;
import com.jbk.project.entity.Employee;
import com.jbk.project.entity.Registration;





@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao dao;
	
	@Override
	public HashMap<String,Object> checkLogin(String email, String password) {
		System.out.println("Service Login Check");
		Registration user =dao.checkLogin(email, password);
		HashMap<String,Object> hashMap = new HashMap<String, Object>();
		if(user==null) {
			hashMap.put("msg", "Invalid User");
			hashMap.put("user", user);
		}else {
			hashMap.put("msg", "Valid User");
			hashMap.put("user", user);
		}
		return hashMap;
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return dao.getAllEmployee();
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		return dao.getEmployeeById(id);
	}

	@Override
	public Employee getEmployeeByName(String name) {
		
		return dao.getEmployeeByName(name);
	}

	@Override
	public List<Employee> getAllEmployeeByStatus(String status) {
		
		return dao.getAllEmployeeByStatus(status);
	}

	@Override
	public String addEmployee(Employee employee) {
		
		return dao.addEmployee(employee);
	}

	@Override
	public String addCountry(Country country) {
		
		return dao.addCountry(country);
	}

	@Override
	public List<Country> getAllCountry() {
		
		return dao.getAllCountry();
	}

	@Override
	public Country getCountryById(int cid) {
	
		return dao.getCountryById(cid);
	}

	@Override
	public Country getCountryByName(String cname) {
		
		return dao.getCountryByName(cname);
	}

	@Override
	public String deleteCountryByName(String cname) {
		
		return dao.deleteCountryByName(cname);
	}

	@Override
	public String deleteEmployeeById(int id) {
		
		return dao.deleteEmployeeById(id);
	}

	@Override
	public List<Employee> getAllListBeforeToday() {
		
		return dao.getAllListBeforeToday();
	}

	@Override
	public String updateCountry(Country country) {
		
		return dao.updateCountry(country);
	}

	@Override
	public String updateEmployee(Employee employee) {
	
		return dao.updateEmployee(employee);
	}

	

	@Override
	public String changeStatus(int id) {
		Employee employee =dao.getEmployeeById(id);
		String string ="";
		if(employee.getStatus().equalsIgnoreCase("active")) {
			employee.setStatus("Inactive");
			dao.updateEmployee(employee);
			string ="Status Changed Successfully";
		}
		else if(employee.getStatus().equalsIgnoreCase("Inactive")) {
			employee.setStatus("Active");
			dao.updateEmployee(employee);
			string ="Status Changed Successfully";
		}
		else if(employee.getStatus().equalsIgnoreCase("Suspend")) {
			string ="Already Suspended, so Employee Status Can't Change ";
		}
		return string;
	}
	


	@Override
	public void readExcel() {
		dao.readExcel();
		
	}

	


}
