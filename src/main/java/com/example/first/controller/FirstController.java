package com.example.first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.first.bean.UserBean;

@Controller
public class FirstController {
	@Autowired
	UserBean user;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("greeting", "お世話になります。");
		return "hello";
	}

	@RequestMapping("session1")
	public String session1() {
		user.setId("session@example.com");
		user.setName("セッション太郎");
		return "session1";
	}

	@RequestMapping("foobar")
	public String foobar() {
	return "foobar";
	}

}
