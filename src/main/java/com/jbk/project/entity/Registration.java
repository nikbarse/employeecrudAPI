package com.jbk.project.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Registration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false,unique = true,length = 50)
	private String username;
	@Column(nullable = false,unique = true,length = 50)
	private String password;
	
	@Column(nullable = false,unique = true,length = 150)
	private String email;
	@DateTimeFormat
	private String createdDate;
	@Column(nullable = false,length = 13)
	private String mobileNo;
	@Column(nullable = false,length = 150)
	private String fullName;
	@Column(nullable = false,length = 20)
	private String gender;
	@Column(nullable = false,length = 50)
	private String country;
	@Column(nullable = false,length = 10)
	private int age;
	
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Registration(int id, String username, String password, String email, String createdDate, String mobileNo,
			String fullName, String gender, String counrty, int age) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.createdDate = createdDate;
		this.mobileNo = mobileNo;
		this.fullName = fullName;
		this.gender = gender;
		this.country = counrty;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCounrty() {
		return country;
	}

	public void setCounrty(String counrty) {
		this.country = counrty;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", createdDate=" + createdDate + ", mobileNo=" + mobileNo + ", fullName=" + fullName + ", gender="
				+ gender + ", counrty=" + country + ", age=" + age + "]";
	}
	
	
}
