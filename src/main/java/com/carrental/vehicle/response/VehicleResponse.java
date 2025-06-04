package com.carrental.vehicle.response;

import com.carrental.enumm.FuelType;
import com.carrental.enumm.VehicleType;

public class VehicleResponse {

	private String model;
	private String fuelType; 
	private int seatingCapacity;
	private double mileage;
	private double dailyRentalPrice;
	private double hourlyRentalPrice;
	private String vehicleType;
	private boolean gpsEnabled;
	private boolean airConditioned;
	
	public VehicleResponse (VehicleResponsible responsible ) {
		this.model = responsible.getModel();
		this.seatingCapacity = responsible.getSeatingCapacity();
		this.fuelType = responsible.getFuelType().toString();
		this.mileage = responsible.getMileage();
		
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
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
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public boolean isGpsEnabled() {
		return gpsEnabled;
	}
	public void setGpsEnabled(boolean gpsEnabled) {
		this.gpsEnabled = gpsEnabled;
	}
	public boolean isAirConditioned() {
		return airConditioned;
	}
	public void setAirConditioned(boolean airConditioned) {
		this.airConditioned = airConditioned;
	}
	
	
}
