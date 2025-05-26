package com.carrental.security.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.carrental.security.repository.CustomerRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private CustomerRepository customerRepo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException { // your repository
		
	        Optional<CustomUser> user = customerRepo.findByEmail(email);
	        if (user == null) {
	            throw new UsernameNotFoundException("User not found with username: " + email);
	        }
	        return new CustomUserDetails(user.get());
	    
	}

}
