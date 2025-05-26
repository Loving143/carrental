package com.carrental.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrental.response.ResponseMessage;
import com.carrental.security.dto.RegisterCustomerRequest;
import com.carrental.security.dto.SwitchRoleRequest;
import com.carrental.security.service.CustomerService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private CustomerService custService;
	
	@PostMapping("/register")
	public ResponseEntity<?> RegisterUser(@RequestBody RegisterCustomerRequest request) {
		custService.registerCustomer(request);
		return ResponseEntity.ok(new ResponseMessage("1","User Registered Successfully!"));
	}
	
	@PostMapping("/switch-role")
	public ResponseEntity<?> switchRole(@RequestBody SwitchRoleRequest request,Authentication auth){
		return ResponseEntity.ok(new ResponseMessage("1",custService.switchRole(request,auth)));
	}
}
