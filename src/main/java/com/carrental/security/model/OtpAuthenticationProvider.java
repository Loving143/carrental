package com.carrental.security.model;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.carrental.security.service.OtpService;

public class OtpAuthenticationProvider implements AuthenticationProvider{

	 private final UserDetailsService userDetailsService;
	    private final OtpService otpService; // Your custom service to validate OTP

	    public OtpAuthenticationProvider(UserDetailsService userDetailsService, OtpService otpService) {
	        this.userDetailsService = userDetailsService;
	        this.otpService = otpService;
	    }

	    @Override
	    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	        String username = (String) authentication.getPrincipal();
	        String otp = (String) authentication.getCredentials();

	        UserDetails user = userDetailsService.loadUserByUsername(username);

	        if (user == null) {
	            throw new BadCredentialsException("User not found");
	        }

	        boolean isOtpValid = otpService.validateOtp(username, otp);
	        if (!isOtpValid) {
	            throw new BadCredentialsException("Invalid OTP");
	        }

	        // Mark authentication as fully authenticated with user's authorities
	        return new OtpAuthenticationToken(user, otp, user.getAuthorities());
	    }

	    @Override
	    public boolean supports(Class<?> authentication) {
	        return OtpAuthenticationToken.class.isAssignableFrom(authentication);
	    }

}
