package com.carrental.vehicle.response;

import com.carrental.enumm.FuelType;

public interface VehicleResponsible {
	
	String getModel();
	FuelType getFuelType();
	Integer getSeatingCapacity();
	Double getMileage();
	Double getDailyRentalPrice();
	Double getHourlyRentalPrice();
	String getVehicleType();
	Boolean getgpsEnabled();
	Boolean getAirConditioned();
}
