package com.carrental.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrental.response.ResponseMessage;
import com.carrental.vehicle.dto.AddVehicleRequest;
import com.carrental.vehicle.model.Vehicle;
import com.carrental.vehicle.service.VehicleService;

@RestController
@RequestMapping("/vehicle")

public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	 @PostMapping("/add")
	 @PreAuthorize("hasRole('USER')")
	 public ResponseEntity<?> addVehicle( @RequestBody AddVehicleRequest request) {
		 vehicleService.addVehicle(request);
	     return  ResponseEntity.ok(new ResponseMessage("1","Vehicle added successfully"));
	  }
	 
	 @GetMapping("/{id}")
	 @PreAuthorize("hasRole('ADMIN') OR hasRole('USER') ")
	 public ResponseEntity<Vehicle> getVehicleById(@PathVariable Integer id) {
	     return ResponseEntity.ok(vehicleService.getVehicleById(id));
	 }

	 @PutMapping("/{id}")
	 @PreAuthorize("hasRole('ADMIN')")
	 public ResponseEntity<String> updateVehicle(@PathVariable Integer id,  @RequestBody AddVehicleRequest request) {
	     vehicleService.updateVehicle(id, request);
	     return ResponseEntity.ok("Vehicle updated successfully");
	 }
	 
	 @GetMapping("/fetch/byModel/{model}")
	 @PreAuthorize("hasRole('USER')")
	 public ResponseEntity<?>fetchVehicleByModel(@PathVariable String model){
	  return ResponseEntity.ok(new ResponseMessage("1",vehicleService.fetchVehicleByModel(model)));
	 }
	 
	 @GetMapping("/fetch/byPrice/{price}")
	 @PreAuthorize("hasRole('USER')")
	 public ResponseEntity<?>fetchVehicleByPrice(@PathVariable String model){
	  return ResponseEntity.ok(new ResponseMessage("1",vehicleService.fetchVehicleByPrice(model)));
	 }
	 
	 @GetMapping("/fetch/byColor/{color}")
	 @PreAuthorize("hasRole('USER')")
	 public ResponseEntity<?>fetchVehicleByColor(@PathVariable String color){
	  return ResponseEntity.ok(new ResponseMessage("1",vehicleService.fetchVehicleByColor(color)));
	 }
	 
	 @GetMapping("/fetch/byBrand/{brand}")
	 @PreAuthorize("hasRole('USER')")
	 public ResponseEntity<?>fetchVehicleByBrand(@PathVariable String brand){
	  return ResponseEntity.ok(new ResponseMessage("1",vehicleService.fetchVehicleByBrand(brand)));
	 }
	 
	 @GetMapping("/fetch/byFuelType/{fuelType}")
	 @PreAuthorize("hasRole('USER')")
	 public ResponseEntity<?>fetchVehicleByFuelType(@PathVariable String fuelType){
	  return ResponseEntity.ok(new ResponseMessage("1",vehicleService.fetchVehicleByFuelType(fuelType)));
	 }
	 
	 @GetMapping("/fetch/byTransmissionType/{transmissionType}")
	 @PreAuthorize("hasRole('USER')")
	 public ResponseEntity<?>fetchVehicleByTransmissionType(@PathVariable String transmissionType){
	  return ResponseEntity.ok(new ResponseMessage("1",vehicleService.fetchVehicleByTransmissionType(transmissionType)));
	 }
	 
	 @PostMapping("/compare")
	 @PreAuthorize("hasRole('USER')")
	 public ResponseEntity<?>compareCars(@RequestBody List<Integer>carIds){
		return ResponseEntity.ok(new ResponseMessage("1", vehicleService.compareCars(carIds)));
	 }
	 
	 
	 
	 
}
