package com.learn.spring.firstspringbootproject.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String showWelcomePage(ModelMap modelMap) {
		modelMap.put("name", getLoggedInUserName());
		return "home";
	}
/*	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String homeController(ModelMap modelMap, @RequestParam String name, @RequestParam String password) {
		if(!loginService.validateLogin(name, password)) {
			modelMap.put("errorMessage", "Please enter valid credentials");
			return "login";
		}
		modelMap.put("name", name);
		modelMap.put("password", password);
		return "home";
	}
*/
	public String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication()
		.getPrincipal();
		if(principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();
	}
}
