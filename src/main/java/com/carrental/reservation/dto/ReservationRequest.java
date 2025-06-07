package com.carrental.reservation.dto;

import java.time.LocalDate;

import com.carrental.enumm.ReservationStatus;
import com.carrental.security.dto.AddAddressRequest;
import com.carrental.util.Address;

public class ReservationRequest {
	
	private String name;
	private String drivingLicense;
	private String aadhaarNumber;
	private Address dropOffAddress;
	private Integer vehicleId;
	private Integer userId;
	private LocalDate rentalStartDate;
	private LocalDate rentalEndDate;
	private ReservationStatus status;
	private AddAddressRequest address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDrivingLicense() {
		return drivingLicense;
	}
	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
	public String getAadhaarNumber() {
		return aadhaarNumber;
	}
	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}
	public Address getDropOffAddress() {
		return dropOffAddress;
	}
	public void setDropOffAddress(Address dropOffAddress) {
		this.dropOffAddress = dropOffAddress;
	}
	public Integer getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public LocalDate getRentalStartDate() {
		return rentalStartDate;
	}
	public void setRentalStartDate(LocalDate rentalStartDate) {
		this.rentalStartDate = rentalStartDate;
	}
	public LocalDate getRentalEndDate() {
		return rentalEndDate;
	}
	public void setRentalEndDate(LocalDate rentalEndDate) {
		this.rentalEndDate = rentalEndDate;
	}
	public ReservationStatus getStatus() {
		return status;
	}
	public void setStatus(ReservationStatus status) {
		this.status = status;
	}
	public AddAddressRequest getAddress() {
		return address;
	}
	public void setAddress(AddAddressRequest address) {
		this.address = address;
	}
	
	

}
