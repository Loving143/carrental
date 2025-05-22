package com.carrental.security.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails{

	
	private CustomUser user;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		ArrayList<CustomGrantedAuthority>authorities = new ArrayList();
		CustomGrantedAuthority auth = new CustomGrantedAuthority("Read");
		authorities.add(auth);
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	public CustomUserDetails(CustomUser user) {
		super();
		this.user = user;
	}
	
}
