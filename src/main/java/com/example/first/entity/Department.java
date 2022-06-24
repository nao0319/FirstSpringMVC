package com.example.first.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="department")
public class Department implements Serializable {
	@Id
	@Column(name = "no")
	private Integer no;
	@Column(name = "name")
	private String name;
	@OneToMany(mappedBy = "dept",cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Employee> employees;
	
	public Department() {
	}

	public Department(Integer no, String name) {
		this.no = no;
		this.name = name;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}
