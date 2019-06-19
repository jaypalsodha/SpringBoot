package com.learn.spring.firstspringbootproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/login")
	public String loginController(@RequestParam String parameter, ModelMap modelMap) {
		System.out.println(parameter);
		modelMap.put("login", parameter);
		return "login";
	}

	@RequestMapping("/bilBoard")
	public String billBoardTest() {
		return "billBoard";
	}
}
