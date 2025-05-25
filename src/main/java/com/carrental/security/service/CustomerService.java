package com.carrental.security.service;

import org.springframework.security.core.Authentication;

import com.carrental.security.dto.RegisterCustomerRequest;
import com.carrental.security.dto.SwitchRoleRequest;

public interface CustomerService {

	void registerCustomer(RegisterCustomerRequest request);

	String switchRole(SwitchRoleRequest request, Authentication auth);

}
