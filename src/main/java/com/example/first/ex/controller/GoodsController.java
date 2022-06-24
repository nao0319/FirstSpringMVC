package com.example.first.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.first.ex.entity.Category;
import com.example.first.ex.entity.CategoryRepository;
import com.example.first.ex.entity.Goods;
import com.example.first.ex.entity.GoodsRepository;


@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	GoodsRepository goodsRepository;
	
	@Autowired
	CategoryRepository ctgRepository;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Goods> list = goodsRepository.findAll();
		model.addAttribute("goods", list);
		return "goods/index";
	}
	
	@RequestMapping("input")
	public String input(Model model) {
		List<Category> list = ctgRepository.findAll();
		model.addAttribute("categories", list);
		return "goods/input";
	}
	
	@RequestMapping("create")
	public String save(
			Model model,
			@ModelAttribute("good") Goods goods,
			@RequestParam("categ") Integer category) {
		goodsRepository.save(goods);
		return "goods/save";
	}
}
