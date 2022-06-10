package com.jbk.project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "country",catalog = "angular_Project")
public class Country {
	
	private Integer cid;
	private String cname;
//	private Employee employee;
	
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Country(Integer cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
//		this.employee = employee;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cid",nullable = false,unique = true)
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Column(name="cname",nullable = false,length = 45)
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
////	@OneToOne (fetch = FetchType.LAZY)
//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}

	@Override
	public String toString() {
		return "Country [cid=" + cid + ", cname=" + cname + "]";
	}
	
	
}
