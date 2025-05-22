package com.carrental.security.dto;

import java.time.LocalDate;
import java.util.List;

import com.carrental.enumm.Gender;
import com.carrental.security.model.Role;
import com.carrental.util.Address;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

public class RegisterCustomerRequest {

	private String fullName;
	private String email;
	private String password;
	private String phoneNumber;
	private String drivingLicenseNumber;
	private LocalDate dateOfBirth;
	private String gender;
	private AddAddressRequest address;
	private List<AddRoleRequest>roles;
}
