package com.carrental.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrental.vehicle.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{

	boolean existsByRegistrationNumber(String registrationNumber);

}
