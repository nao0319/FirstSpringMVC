package com.example.first.appendix.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.first.appendix.model.entity.Service;

@Controller
@RequestMapping("appendix")
public class ForEachSampleController {
	@RequestMapping("forEachSample1")
	public String forEachSample1(Model model) {
		List<String> list = new ArrayList<String>();
		list.add("おはよう");
		list.add("こんにちは");
		list.add("さようなら");
		model.addAttribute("strList", list);
		return "appendix/forEach1";
	}

	@RequestMapping("forEachSample2")
	public String forEachSample2(Model model) {
		List<Service> services = new ArrayList<Service>();
		Service s1 = new Service(1, "カット", 3000, new Date());
		services.add(s1);
		Service s2 = new Service(2, "シャンプー", 1500, new Date());
		services.add(s2);
		Service s3 = new Service(3, "ドッグラン", 5000, new Date());
		services.add(s3);
		model.addAttribute("services", services);
		return "appendix/forEach2";
	}
}