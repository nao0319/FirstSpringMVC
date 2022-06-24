package com.example.first.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.first.ex.form.IntroduceForm;

@Controller
@RequestMapping("ex2")
public class Ex2Controller {
	@RequestMapping("input2a1")
	public String ex2a1() {
		return "ex2/input2a1";
	}

	@RequestMapping("a1")
	public String profileForm(@ModelAttribute("plofile") IntroduceForm form) {
		return "ex2/ex2a1";
	}
}
