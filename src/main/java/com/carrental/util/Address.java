package com.carrental.util;

import com.carrental.security.dto.AddAddressRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
	
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer id;
	 private String street;
     private String city;
     private String state;
     private String country;
     private String postalCode;
     
     
	public Address(AddAddressRequest address) {
		this.street = address.getStreet();
		this.state = address.getState();
		this.city = address.getCity();
		this.country = address.getCountry();
		this.postalCode = address.getPostalCode();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
