package com.carrental.security.serviceImpl;

import org.springframework.stereotype.Service;

import com.carrental.security.service.OtpService;
@Service
public class OtpServiceImpl implements OtpService{

	@Override
	public boolean validateOtp(String username, String otp) {
		return false;
	}

}
