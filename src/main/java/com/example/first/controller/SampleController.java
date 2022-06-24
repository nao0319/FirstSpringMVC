package com.example.first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.first.bean.UserBean;
import com.example.first.form.SampleForm;

@Controller
@RequestMapping("sample")
public class SampleController {
	@Autowired
	UserBean user;

	@RequestMapping("input")
	public String input() {
		return "sample/input";
	}

	@RequestMapping("form")
	public String form(@ModelAttribute("form") SampleForm form,
			Model model) {
		model.addAttribute("userlen", form.getUser().length());
		model.addAttribute("addrlen", form.getAddress().length());

		return "sample/form";
	}

	@RequestMapping("session2")
	public String session2() {
		user.setName("スコープ次郎");
		return "session2";
	}
}
