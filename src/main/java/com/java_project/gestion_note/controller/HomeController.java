package com.java_project.gestion_note.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java_project.gestion_note.model.Users;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home(Model model) {
		
		model.addAttribute("userForm", new Users());
		return "pages/create-account";

	}
}
