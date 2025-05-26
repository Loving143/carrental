package com.carrental.storage.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AddStorageRequest {

	private String name;
    private String storageCode;
    private double latitude;
    private double longitude;
    private String managerName;
    private String contactNumber;
    @JsonFormat(pattern ="dd-MM-yyyy")
    private LocalDate openingTime;
    @JsonFormat(pattern ="dd-MM-yyyy")
    private LocalDate closingTime;
    private boolean isOperational;
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStorageCode() {
		return storageCode;
	}
	public void setStorageCode(String storageCode) {
		this.storageCode = storageCode;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public LocalDate getOpeningTime() {
		return openingTime;
	}
	public void setOpeningTime(LocalDate openingTime) {
		this.openingTime = openingTime;
	}
	public LocalDate getClosingTime() {
		return closingTime;
	}
	public void setClosingTime(LocalDate closingTime) {
		this.closingTime = closingTime;
	}
	public boolean isOperational() {
		return isOperational;
	}
	public void setOperational(boolean isOperational) {
		this.isOperational = isOperational;
	}
    
    
}
