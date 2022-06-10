package com.jbk.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Employee {
	
	
	private Integer id ;
	private Country country;
	private String name;
	private String phone;
    private String department;
    private String status;
    private Date createddtm;
    private String createdby;
    private Date updateddtm; 
    private String updatedby;
    
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer id, Country country, String name, String phone, String department, String status,
			Date createddtm, String createdby, Date updateddtm, String updatedby) {
		super();
		this.id = id;
		this.country = country;
		this.name = name;
		this.phone = phone;
		this.department = department;
		this.status = status;
		this.createddtm = createddtm;
		this.createdby = createdby;
		this.updateddtm = updateddtm;
		this.updatedby = updatedby;
	}

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id",unique = true,nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@OneToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "cid",nullable = false)
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Column (name = "name",nullable = false,length = 45)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="phone",nullable = false,length = 45)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name="department",nullable = false,length = 45)
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name="status",nullable = false,length = 45)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createddtm",nullable = false,length = 19)
	public Date getCreateddtm() {
		return createddtm;
	}

	public void setCreateddtm(Date createddtm) {
		this.createddtm = createddtm;
	}

	@Column(name="createdby",nullable = false,length = 45)
	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updateddtm",nullable = false,length = 19)
	public Date getUpdateddtm() {
		return updateddtm;
	}

	public void setUpdateddtm(Date updateddtm) {
		this.updateddtm = updateddtm;
	}

	@Column(name="updatedby",nullable = false,length = 45)
	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", country=" + country + ", name=" + name + ", phone=" + phone + ", department="
				+ department + ", status=" + status + ", createddtm=" + createddtm + ", createdby=" + createdby
				+ ", updateddtm=" + updateddtm + ", updatedby=" + updatedby + "]";
	}

	
	
}
