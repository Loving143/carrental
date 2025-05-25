package com.carrental.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrental.security.dto.RegisterCustomerRequest;
import com.carrental.security.service.CustomerService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private CustomerService custService;
	
	@PostMapping("/register")
	public String RegisterUser(@RequestBody RegisterCustomerRequest request) {
		custService.registerCustomer(request);
		return"User registered Successfully";
	}
}
