package com.carrental.security.serviceImpl;

import org.springframework.stereotype.Service;

import com.carrental.security.dto.RegisterCustomerRequest;
import com.carrental.security.model.CustomUser;
import com.carrental.security.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Override
	public void registerCustomer(RegisterCustomerRequest request) {
		
		CustomUser user = new CustomUser(request);
	}

}
