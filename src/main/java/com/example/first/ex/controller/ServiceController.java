package com.example.first.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.first.ex.entity.ServiceRepository;
import com.example.first.ex.form.Service;

@Controller
@RequestMapping("service")
public class ServiceController {

	@Autowired
	ServiceRepository serviceRepository;

	@RequestMapping("/")
	public String index(Model model) {
		List<Service> list = serviceRepository.findAll();
		model.addAttribute("servicies", list);
		return "ex3/index";
	}

	@RequestMapping("input")
	public String newForm() {
		return "ex3/input";
	}

	@RequestMapping("save")
	public String create(
			Model model,
			@ModelAttribute("service") Service service) {
		serviceRepository.save(service);
		return "ex3/save";
	}

	@RequestMapping("edit")
	public String edit(
			Model model,
			@RequestParam("no") Integer no) {
		Service emp = serviceRepository.findById(no).get();
		model.addAttribute("service", emp);
		return "ex3/edit";
	}

	@RequestMapping("update")
	public String edit(
			Model model,
			@ModelAttribute("service") Service empForm) {
		Service emp = serviceRepository.findById(empForm.getNo()).get();
		emp.setSername(empForm.getSername());
		emp.setPrice(empForm.getPrice());
		serviceRepository.save(emp);
		model.addAttribute("service", emp);
		return "ex3/save";
	}

	@RequestMapping("delete")
	public String delete(
			@RequestParam("no") Integer no) {
		serviceRepository.deleteById(no);
		return "redirect:/service/";
	}
}
