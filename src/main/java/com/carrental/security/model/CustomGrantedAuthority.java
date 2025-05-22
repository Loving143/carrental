package com.carrental.security.model;

import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority {
	
	private String authority;

	public CustomGrantedAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
