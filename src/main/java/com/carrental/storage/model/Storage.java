package com.carrental.storage.model;

import java.time.LocalDate;
import java.util.List;

import com.carrental.reservation.model.Reservation;
import com.carrental.vehicle.model.Vehicle;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Storage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String storageCode;
	private double latitude;
	private double longitude;
	private String managerName;
	private String contactNumber;
	private LocalDate openingTime;
	private LocalDate closingTime;
	private boolean isOperational;
	
	@OneToMany(mappedBy="storage", fetch=FetchType.LAZY)
	List<Vehicle>vehicles;
	
	@OneToMany(fetch=FetchType.LAZY)
	List<Reservation>reservations;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
	
	
	

}
