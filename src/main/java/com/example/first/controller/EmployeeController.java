package com.example.first.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.first.entity.Department;
import com.example.first.entity.DepartmentRepository;
import com.example.first.entity.Employee;
import com.example.first.entity.EmployeeRepository;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository deptRepository;

	@RequestMapping("/")
	public String index(Model model) {
		List<Employee> list = employeeRepository.findAll();
		model.addAttribute("employees", list);
		return "employee/index";
	}

	@RequestMapping("new")
	public String newForm(@ModelAttribute Employee emp) {
		return "employee/new";
	}

	@RequestMapping("create")
	public String create(
			Model model,
			@ModelAttribute("employee") @Validated Employee emp,
			BindingResult result) {
		if (result.hasErrors()) {
			return "employee/new";
		}
		employeeRepository.save(emp);
		return "employee/save";
	}

	@RequestMapping("edit")
	public String edit(
			Model model,
			@RequestParam("no") Integer no) {
		Employee emp = employeeRepository.findById(no).get();
		model.addAttribute("employee", emp);
		return "employee/edit";
	}

	@RequestMapping("update")
	public String edit(
			Model model,
			@ModelAttribute("employee") Employee empForm) {
		Employee emp = employeeRepository.findById(empForm.getNo()).get();
		emp.setName(empForm.getName());
		emp.setSalary(empForm.getSalary());
		employeeRepository.save(emp);
		model.addAttribute("employee", emp);
		return "employee/save";
	}

	@RequestMapping("delete")
	public String delete(
			@RequestParam("no") Integer no) {
		employeeRepository.deleteById(no);
		return "redirect:/employee/";
	}

	@RequestMapping("init")
	public String init() {
		employeeRepository.deleteAll();
		deptRepository.deleteAll();
		Department dept1 = new Department(101, "総務部");
		Department dept2 = new Department(201, "経理部");
		Department dept3 = new Department(301, "技術部");
		deptRepository.save(dept1);
		deptRepository.save(dept2);
		deptRepository.save(dept3);
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1234, "田中", 540000, dept1));
		empList.add(new Employee(2345, "山田", 380000, dept3));
		empList.add(new Employee(3456, "鈴木", 250000, dept2));
		empList.add(new Employee(4567, "山本", 290000, dept2));
		empList.add(new Employee(5678, "木村", 470000, dept3));
		empList.add(new Employee(6789, "村田", 330000, dept1));
		employeeRepository.saveAll(empList);
		return "redirect:/employee/";
	}

	@RequestMapping("veteran")
	public String veteran(Model model) {
		List<Employee> list = employeeRepository.findVeteran();
		model.addAttribute("employees", list);
		return "employee/index";
	}

	@RequestMapping("yama")
	public String yama(Model model) {
		List<Employee> list = employeeRepository.findByNameLikePrefix("山");
		model.addAttribute("employees", list);
		return "employee/index";
	}

	@RequestMapping("list")
	public String list(Model model, Pageable pageable) {
		Page<Employee> list = employeeRepository.findAll(pageable);
		model.addAttribute("employees", list);
		return "employee/list";
	}

}
