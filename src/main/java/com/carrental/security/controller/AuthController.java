package com.carrental.security.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carrental")
public class AuthController {

	@PostMapping("/login")
	public String login() {
		
		return"";
	}
	
	@PostMapping("/register")
	public String RegisterUser() {
		
		return"";
	}
}
