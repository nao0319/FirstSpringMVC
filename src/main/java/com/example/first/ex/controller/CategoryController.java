package com.example.first.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.first.ex.entity.Category;
import com.example.first.ex.entity.CategoryRepository;

@Controller
@RequestMapping("category")
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Category> list = categoryRepository.findAll();
		model.addAttribute("categories", list);
		return "category/index";
	}
	
	@RequestMapping("input")
	public String input6a1() {
		return "category/input";
	}
	
	@RequestMapping("create")
	public String save(@ModelAttribute("category") Category ctg) {
		categoryRepository.save(ctg);
		return "category/save";
	}
}
