package com.example.first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.first.entity.Department;
import com.example.first.entity.DepartmentRepository;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	DepartmentRepository deptRepository;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("dept", new Department());
		return "department/index";
	}

	@RequestMapping("search")
	public String create(Model model, @RequestParam("no") Integer no) {
		Department dept = deptRepository.findById(no).get();
		model.addAttribute("dept", dept);
		return "department/index";
	}
}
