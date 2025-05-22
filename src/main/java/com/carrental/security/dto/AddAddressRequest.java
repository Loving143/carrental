package com.carrental.security.dto;

import java.time.LocalDate;
import java.util.List;

import com.carrental.enumm.Gender;
import com.carrental.security.model.Role;
import com.carrental.util.Address;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

public class AddAddressRequest {

	 private String street;
     private String city;
     private String state;
     private String country;
     private String postalCode;
     
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
     
     
	
}
