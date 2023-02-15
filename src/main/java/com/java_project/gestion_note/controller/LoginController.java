package com.java_project.gestion_note.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.java_project.gestion_note.model.Users;
import com.java_project.gestion_note.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	private UserRepository userRep;

	@Autowired
	 private PasswordEncoder passwordEncoder;

	 @Autowired
 private AuthenticationManager authenticationManager;

	@PostMapping("/register")
	public String registerUser(@ModelAttribute Users user, Model model){

	//   // add check for username exists in a DB
	//   if(userRep.existsByUsername(user.getUsername())){
	// 	  return "pages/login";
	//   }

	//   // add check for email exists in DB
	//   if(userRep.existsByEmail(user.getEmail())){
	// 	  return "pages/login";
	//   }

	  // create user object
	  Users usernew = new Users();
	  usernew.setUsername(user.getUsername());
	  usernew.setEmail(user.getEmail());
	  usernew.setPassword(passwordEncoder.encode(user.getPassword()));

	//   Role roles = roleRep.findByName("ROLE_USER").get();
	//   usernew.setRoles(Collections.singleton(roles));

	  userRep.save(usernew);
	  
	  return "redirect:/login"; 

  }



   @GetMapping("/login")
   public String login(Model model) {

	model.addAttribute("userForm", new Users());
      return "pages/login";
   }

   @PostMapping("/checkLogin")
  	public String checkUserConnection(@ModelAttribute Users user, Model model) {
		  System.out.println(user);
  		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
		if (auth != null && authentication.isAuthenticated()) {
			// User is authenticated
			// Do something with the authenticated user's information
			return "/index";
		} else {
			// User is not authenticated
			// Redirect to login page or show an error message
			return "/404";
		}
        
        
  		
  	}

	  @GetMapping("/admin_page")
	  public String homepage() {
   
		 return "index";
	  }

	
}

