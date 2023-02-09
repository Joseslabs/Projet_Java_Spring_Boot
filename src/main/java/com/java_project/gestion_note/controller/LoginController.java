package com.java_project.gestion_note.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	@GetMapping("/")
	public String showLogin() {
		return "pages/login";
	}
	
	@RequestMapping("/login")
	public void login(HttpServletRequest request) {
		if(request.getAttribute("username")) {
			
		}
		HomeController homeC = new HomeController();
		homeC.home();
	}
	
	@GetMapping("/logout")
	public void logout() {
		this.showLogin();
	}
}
