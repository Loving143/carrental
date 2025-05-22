package com.carrental.security.model;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomAuthenticationProvider implements AuthenticationProvider{

	 private final UserDetailsService userDetailsService;
	    private final PasswordEncoder passwordEncoder;

	    public CustomAuthenticationProvider(UserDetailsService userDetailsService,
	                                        PasswordEncoder passwordEncoder) {
	        this.userDetailsService = userDetailsService;
	        this.passwordEncoder = passwordEncoder;
	    }

	    @Override
	    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	        String username = authentication.getName();
	        String rawPassword = authentication.getCredentials().toString();

	        UserDetails user = userDetailsService.loadUserByUsername(username);

	        if (user == null || !passwordEncoder.matches(rawPassword, user.getPassword())) {
	            throw new BadCredentialsException("Invalid username or password");
	        }

	        // You can also add logic here to check if user is allowed to proceed to second factor

	        return new UsernamePasswordAuthenticationToken(user, rawPassword, user.getAuthorities());
	    }

	    @Override
	    public boolean supports(Class<?> authentication) {
	        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	    }

}
