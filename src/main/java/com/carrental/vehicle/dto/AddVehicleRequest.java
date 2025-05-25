package com.carrental.vehicle.dto;

import java.time.LocalDate;

import com.carrental.enumm.FuelType;
import com.carrental.enumm.TransmissionType;
import com.carrental.enumm.VehicleStatus;
import com.carrental.enumm.VehicleType;

public class AddVehicleRequest {
	
	    private String registrationNumber;
	    private String vin;
	    private String make;
	    private String model;
	    private String variant;
	    private int manufacturingYear;

	    private String color;
	    private FuelType fuelType;
	    private TransmissionType transmissionType;
	    private int seatingCapacity;
	    private double mileage;
	    private double dailyRentalPrice;
	    private double hourlyRentalPrice;
	    private VehicleStatus status;
	    private boolean airConditioned;
	    private boolean gpsEnabled;
	    private boolean musicSystem;
	    private boolean automaticLock;

	    private VehicleType vehicleType;

	    private double engineCapacity;
	    private double currentOdometer;

	    private LocalDate lastServiceDate;
	    private LocalDate insuranceExpiryDate;
	    private String description;
	    private boolean active;

	    private Integer storageId;
	    private Integer reservationId;
		public String getRegistrationNumber() {
			return registrationNumber;
		}
		public void setRegistrationNumber(String registrationNumber) {
			this.registrationNumber = registrationNumber;
		}
		public String getVin() {
			return vin;
		}
		public void setVin(String vin) {
			this.vin = vin;
		}
		public String getMake() {
			return make;
		}
		public void setMake(String make) {
			this.make = make;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public String getVariant() {
			return variant;
		}
		public void setVariant(String variant) {
			this.variant = variant;
		}
		public int getManufacturingYear() {
			return manufacturingYear;
		}
		public void setManufacturingYear(int manufacturingYear) {
			this.manufacturingYear = manufacturingYear;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public FuelType getFuelType() {
			return fuelType;
		}
		public void setFuelType(FuelType fuelType) {
			this.fuelType = fuelType;
		}
		public TransmissionType getTransmissionType() {
			return transmissionType;
		}
		public void setTransmissionType(TransmissionType transmissionType) {
			this.transmissionType = transmissionType;
		}
		public int getSeatingCapacity() {
			return seatingCapacity;
		}
		public void setSeatingCapacity(int seatingCapacity) {
			this.seatingCapacity = seatingCapacity;
		}
		public double getMileage() {
			return mileage;
		}
		public void setMileage(double mileage) {
			this.mileage = mileage;
		}
		public double getDailyRentalPrice() {
			return dailyRentalPrice;
		}
		public void setDailyRentalPrice(double dailyRentalPrice) {
			this.dailyRentalPrice = dailyRentalPrice;
		}
		public double getHourlyRentalPrice() {
			return hourlyRentalPrice;
		}
		public void setHourlyRentalPrice(double hourlyRentalPrice) {
			this.hourlyRentalPrice = hourlyRentalPrice;
		}
		public VehicleStatus getStatus() {
			return status;
		}
		public void setStatus(VehicleStatus status) {
			this.status = status;
		}
		public boolean isAirConditioned() {
			return airConditioned;
		}
		public void setAirConditioned(boolean airConditioned) {
			this.airConditioned = airConditioned;
		}
		public boolean isGpsEnabled() {
			return gpsEnabled;
		}
		public void setGpsEnabled(boolean gpsEnabled) {
			this.gpsEnabled = gpsEnabled;
		}
		public boolean isMusicSystem() {
			return musicSystem;
		}
		public void setMusicSystem(boolean musicSystem) {
			this.musicSystem = musicSystem;
		}
		public boolean isAutomaticLock() {
			return automaticLock;
		}
		public void setAutomaticLock(boolean automaticLock) {
			this.automaticLock = automaticLock;
		}
		public VehicleType getVehicleType() {
			return vehicleType;
		}
		public void setVehicleType(VehicleType vehicleType) {
			this.vehicleType = vehicleType;
		}
		public double getEngineCapacity() {
			return engineCapacity;
		}
		public void setEngineCapacity(double engineCapacity) {
			this.engineCapacity = engineCapacity;
		}
		public double getCurrentOdometer() {
			return currentOdometer;
		}
		public void setCurrentOdometer(double currentOdometer) {
			this.currentOdometer = currentOdometer;
		}
		public LocalDate getLastServiceDate() {
			return lastServiceDate;
		}
		public void setLastServiceDate(LocalDate lastServiceDate) {
			this.lastServiceDate = lastServiceDate;
		}
		public LocalDate getInsuranceExpiryDate() {
			return insuranceExpiryDate;
		}
		public void setInsuranceExpiryDate(LocalDate insuranceExpiryDate) {
			this.insuranceExpiryDate = insuranceExpiryDate;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}
		public Integer getStorageId() {
			return storageId;
		}
		public void setStorageId(Integer storageId) {
			this.storageId = storageId;
		}
		public Integer getReservationId() {
			return reservationId;
		}
		public void setReservationId(Integer reservationId) {
			this.reservationId = reservationId;
		}
	    
	    
}
