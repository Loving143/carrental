package com.carrental.security.model;

import java.time.LocalDate;
import java.util.List;

import com.carrental.enumm.Gender;
import com.carrental.security.dto.RegisterCustomerRequest;
import com.carrental.util.Address;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer")
public class CustomUser {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="cust_seq")
	@SequenceGenerator(name ="cust_seq",sequenceName ="Customer_Sequence",allocationSize=1)
	private Integer id;
	private String fullName;
	private String email;
	private String password;
	private String phoneNumber;
	private String drivingLicenseNumber;
	private LocalDate dateOfBirth;
	private Gender gender;
	@OneToOne
	private Address address;
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Role>roles;
	private boolean verified;
	private boolean active;
	public CustomUser(RegisterCustomerRequest request) {
		this.fullName = request.getFullName();
		this.email = request.getEmail();
		this.gender = request.getGender();
		this.phoneNumber = request.getPhoneNumber();
		this.drivingLicenseNumber = request.getDrivingLicenseNumber();
		this.dateOfBirth = request.getDateOfBirth();
		Address address = new Address(request.getAddress());
		this.address = address;
		this.active = true;
	}
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
}
