package com.example.onlineexam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.onlineexam.entity.AppUser;
import com.example.onlineexam.entity.Role;
import com.example.onlineexam.service.AppUserService;
import com.example.onlineexam.service.RoleService;

@Controller
public class LoginController {
	@Autowired
	private AppUserService appUserService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/login")
	public String showLogin() {
		return "security/login";
	}
	
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("user", new AppUser());
		List<Role> role =roleService.getRoles() ;
		model.addAttribute("roles",role);
		return "security/register";
	}
	
	@PostMapping("/register")
	public String processRegister(@ModelAttribute("user")AppUser user) {
		appUserService.createUser(user);
		return "redirect:/";
	}
	
}
