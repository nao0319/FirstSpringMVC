package com.example.first.yokoami.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.first.yokoami.entity.Owner;
import com.example.first.yokoami.entity.OwnerRepository;

@Controller
@RequestMapping("owner")
public class OwnerController {
	@Autowired
	OwnerRepository ownerRepository;

	@RequestMapping("new")
	public String input() {
		return "owner/new";
	}
	
	@RequestMapping("create")
	public String create(
			Model model,
			@ModelAttribute("owner") @Validated Owner own,
			BindingResult result) {
		if (result.hasErrors()) {
			return "owner/new";
		}
		ownerRepository.save(own);
		return "owner/index";
	}
}
