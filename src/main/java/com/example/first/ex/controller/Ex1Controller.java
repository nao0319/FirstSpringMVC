package com.example.first.ex.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ex1")
public class Ex1Controller {
	@RequestMapping("a1")
	public String ex1a1() {
		return "ex1/ex1a1";
	}

	@RequestMapping("a2")
	public String ex1a2(Model model) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String fDate = sdf.format(date);
		model.addAttribute("today", fDate);
		return "ex1/ex1a2";
	}

	@RequestMapping("input1a3")
	public String input() {
		return "ex1/input1a3";
	}

	@RequestMapping(value = "a3", method= RequestMethod.GET)
	public String ex1a3(@RequestParam("num1") Integer num1,
			@RequestParam("num2") Integer num2,
			Model model) {
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		model.addAttribute("sum", num1 + num2);
		return "ex1/ex1a3";
	}
	
	@RequestMapping("input1a4")
	public String input1a3() {
		return "ex1/input1a4";
	}
	
	@RequestMapping("a4")
	public String ex1a4(@RequestParam("formText") String formText,
			Model model) {
		model.addAttribute("formText",formText);
		model.addAttribute("txtlen", formText.length());
		return "ex1/ex1a4";
	}
	
	@RequestMapping("input1b1")
	public String input1b1() {
		return "ex1/input1b1";
	}
	
	@RequestMapping("b1")
	public String ex1b1(@RequestParam("age") String age,
			@RequestParam("hobby") String[] hobby,
			Model model) {
		model.addAttribute("age", age);
		model.addAttribute("hobby", hobby);
		return "ex1/ex1b1";
	}
}
