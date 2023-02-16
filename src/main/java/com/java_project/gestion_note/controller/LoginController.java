package com.java_project.gestion_note.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.java_project.gestion_note.model.Admin;
import com.java_project.gestion_note.service.AdminService;

import ch.qos.logback.core.model.Model;


@Controller
public class LoginController {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private HomeController homeController;
	
	@GetMapping("/")
	public String showLogin() {
		return "pages/login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute Admin adm, Model model) {
		
		if(adm.getEmail().equals(adminService.read(1).getEmail()) && adm.getPassword().equals(adminService.read(1).getPassword())) {
			return "redirect:/home";
		}
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/";
	}
}
