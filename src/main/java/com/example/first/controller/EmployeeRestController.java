package com.example.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.first.entity.Employee;
import com.example.first.entity.EmployeeRepository;

@RestController
@RequestMapping("employees")
public class EmployeeRestController {
	@Autowired
	EmployeeRepository empRepos;

	//localhost:8080/empoloyees/111
	@RequestMapping(path = "{no}", method = RequestMethod.GET)
	public Employee show(@PathVariable Integer no) {
		return empRepos.findById(no).get();
	}

	//localhost:8080/empoloyees
	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<Employee> index() {
		return empRepos.findAll();
	}
	
}
