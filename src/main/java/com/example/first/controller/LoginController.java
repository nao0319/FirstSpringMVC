package com.example.first.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.first.entity.User;
import com.example.first.entity.UserRepository;
import com.example.first.form.LoginForm;

@Controller
@RequestMapping("/login")
@SessionAttributes(names = { "user" })
public class LoginController {
	@Autowired
	UserRepository userRepository;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("form", new LoginForm());
		return "login/index";
	}

	@RequestMapping("auth")
	public String auth(
			Model model,
			@ModelAttribute("form") @Validated LoginForm form,
			BindingResult result,
			RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			return "login/index";
		}
		User user = userRepository.findByIdAndPassword(form.getId(), form.getPassword());
		if (user == null) {
			redirectAttrs.addFlashAttribute("flash", "IDまたはパスワードが誤っています");
			return "redirect:/login/";
		}
		model.addAttribute("user", user);
		redirectAttrs.addFlashAttribute("flash", "ログインに成功しました");
		return "redirect:/login/mypage";
	}

	@RequestMapping("mypage")
	public String mypage() {
		return "login/mypage";
	}

	@RequestMapping("init")
	public String init() {
		userRepository.deleteAll();
		List<User> userList = new ArrayList<>();
		userList.add(new User("user1@example.com", "スプリング太郎", "1"));
		userList.add(new User("user2@example.com", "ブート花子", "2"));
		userList.add(new User("user3@example.com", "エムブイシー三郎", "3"));
		userRepository.saveAll(userList);
		return "redirect:/login/";
	}

	@RequestMapping("next")
	public String next(SessionStatus status) {
		status.setComplete();
		return "login/next";
	}

	@RequestMapping("last")
	public String last() {
		return "login/last";
	}

}
