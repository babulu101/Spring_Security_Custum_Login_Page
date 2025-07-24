package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Student_Controller {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
}
