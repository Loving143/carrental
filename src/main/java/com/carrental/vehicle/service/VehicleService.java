package com.carrental.vehicle.service;

import com.carrental.vehicle.dto.AddVehicleRequest;
import com.carrental.vehicle.model.Vehicle;

public interface VehicleService {

	 void addVehicle(AddVehicleRequest request) ;

	void updateVehicle(Integer id, AddVehicleRequest request);

	Vehicle getVehicleById(Integer id);
	
}
