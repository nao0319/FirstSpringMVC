package com.example.first.appendix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.first.appendix.form.ParamSampleForm;

@Controller
@RequestMapping("appendix")
public class ParamSampleController {
	@RequestMapping("input1")
	public String input1() {
		return "appendix/input1";
	}

	@RequestMapping("form1")
	public String form(@RequestParam("id") Integer id,
			@RequestParam("name") String name,
			Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "appendix/form1";
	}

	@RequestMapping("input2")
	public String input2() {
		return "appendix/input2";
	}

	@RequestMapping("form2")
	public String form2(@ModelAttribute("sampleForm") ParamSampleForm paramSampleForm) {
		return "appendix/form2";
	}

}
