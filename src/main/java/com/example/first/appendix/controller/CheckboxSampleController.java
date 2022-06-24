package com.example.first.appendix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("appendix")
public class CheckboxSampleController {
	@RequestMapping("checkBoxInput")
	public String checkBoxInput() {
		return "appendix/checkBoxInput";
	}

	@RequestMapping("checkBoxForm")
	public String checkBoxForm(@RequestParam("learn") String[] learn,
			Model model) {
		model.addAttribute("learn", learn);
		return "appendix/checkBoxForm";
	}
}