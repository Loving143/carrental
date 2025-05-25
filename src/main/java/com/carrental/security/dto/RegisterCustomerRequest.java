package com.carrental.security.dto;

import java.time.LocalDate;
import java.util.List;

import com.carrental.enumm.Gender;
import com.carrental.security.model.Role;
import com.carrental.util.Address;


public class RegisterCustomerRequest {

	private String fullName;
	private String email;
	private String password;
	private String phoneNumber;
	private String drivingLicenseNumber;
	private LocalDate dateOfBirth;
	private Gender gender;
	private AddAddressRequest address;
	private List<AddRoleRequest>roles;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDrivingLicenseNumber() {
		return drivingLicenseNumber;
	}
	public void setDrivingLicenseNumber(String drivingLicenseNumber) {
		this.drivingLicenseNumber = drivingLicenseNumber;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public AddAddressRequest getAddress() {
		return address;
	}
	public void setAddress(AddAddressRequest address) {
		this.address = address;
	}
	public List<AddRoleRequest> getRoles() {
		return roles;
	}
	public void setRoles(List<AddRoleRequest> roles) {
		this.roles = roles;
	}
}
