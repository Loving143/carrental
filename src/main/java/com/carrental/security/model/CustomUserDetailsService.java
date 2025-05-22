package com.carrental.security.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.carrental.security.repository.CustomerRepository;

public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private CustomerRepository customerRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // your repository
		
	        Optional<CustomUser> user = customerRepo.findByUsername(username);
	        if (user == null) {
	            throw new UsernameNotFoundException("User not found with username: " + username);
	        }
	        return new CustomUserDetails(user.get());
	    
	}

}
