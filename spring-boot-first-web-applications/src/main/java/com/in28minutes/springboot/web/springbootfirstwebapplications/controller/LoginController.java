package com.in28minutes.springboot.web.springbootfirstwebapplications.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.web.springbootfirstwebapplications.service.LoginService;

// /login => "Hello World"
@Controller
@SessionAttributes("name")
public class LoginController {

	@Autowired
	LoginService service;
	
	// Model

	@RequestMapping(value = "/login", method = RequestMethod.GET)

	public String showLoginPage(ModelMap model) {
		// model.put("name", name);
		// System.out.println("The name is"+ name);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)

	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {

		boolean isValidUser = service.validateUser(name, password);
		if (!isValidUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		} else {
			model.put("name", name);
			model.put("pwd", password);
			// System.out.println("The name is"+ name);
			return "welcome";
		}
	}

}
