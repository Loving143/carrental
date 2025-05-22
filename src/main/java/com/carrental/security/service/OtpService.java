package com.carrental.security.service;

public interface OtpService {

	boolean validateOtp(String username, String otp);

}
