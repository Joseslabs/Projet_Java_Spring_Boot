package com.java_project.gestion_note.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.java_project.gestion_note.item.LoginItem;
import com.java_project.gestion_note.service.AdminService;


@Controller
public class LoginController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/")
	public String showLogin() {
		return "pages/login";
	}
	
	@PostMapping("/login")
	public void login(@RequestBody LoginItem loginItem) {
		System.out.println(loginItem.getEmail());
		/*if(request.getAttribute("email") != adminService.read(1).getEmail() || request.getAttribute("password") != adminService.read(1).getPassword()) {
			this.showLogin();
		}*/
		/*HomeController homeC = new HomeController();
		homeC.home();*/
	}
	
	@GetMapping("/logout")
	public void logout() {
		this.showLogin();
	}
}
