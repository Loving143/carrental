package com.carrental.vehicle.service;

import java.util.List;

import com.carrental.vehicle.dto.AddVehicleRequest;
import com.carrental.vehicle.model.Vehicle;
import com.carrental.vehicle.response.VehicleResponse;

public interface VehicleService {

	 void addVehicle(AddVehicleRequest request) ;

	void updateVehicle(Integer id, AddVehicleRequest request);

	Vehicle getVehicleById(Integer id);

	List<VehicleResponse> fetchVehicleByModel(String model);

	List<VehicleResponse> fetchVehicleByPrice(String model);

	List<VehicleResponse> fetchVehicleByColor(String color);

	List<VehicleResponse> fetchVehicleByBrand(String brand);

	List<VehicleResponse> fetchVehicleByFuelType(String fuelType);

	List<VehicleResponse> fetchVehicleByTransmissionType(String transmissionType);

	List<VehicleResponse> compareCars(List<Integer> carIds);
	
}
