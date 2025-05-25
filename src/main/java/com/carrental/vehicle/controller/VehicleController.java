package com.carrental.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carrental.vehicle.dto.AddVehicleRequest;
import com.carrental.vehicle.model.Vehicle;
import com.carrental.vehicle.service.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	 @PostMapping("/add")
	 public ResponseEntity<String> addVehicle( @RequestBody AddVehicleRequest request) {
	        vehicleService.addVehicle(request);
	        return ResponseEntity.ok("Vehicle added successfully");
	  }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Integer id) {
	        return ResponseEntity.ok(vehicleService.getVehicleById(id));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<String> updateVehicle(@PathVariable Integer id,  @RequestBody AddVehicleRequest request) {
	        vehicleService.updateVehicle(id, request);
	        return ResponseEntity.ok("Vehicle updated successfully");
	    }
}
