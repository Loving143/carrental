package com.carrental.vehicle.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrental.reservation.model.Reservation;
import com.carrental.reservation.repository.ReservationRepository;
import com.carrental.storage.model.Storage;
import com.carrental.storage.repository.StorageRepository;
import com.carrental.vehicle.dto.AddVehicleRequest;
import com.carrental.vehicle.model.Vehicle;
import com.carrental.vehicle.repository.VehicleRepository;
import com.carrental.vehicle.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{

		@Autowired
		private  VehicleRepository vehicleRepository;
		@Autowired
	    private  StorageRepository storageRepository;
		@Autowired
	    private  ReservationRepository reservationRepository;

	    @Override
	    public void addVehicle(AddVehicleRequest request) {
	    	 if (vehicleRepository.existsByRegistrationNumber(request.getRegistrationNumber())) {
	             throw new IllegalArgumentException("Vehicle with this registration number already exists");
	         }
	         Vehicle vehicle = mapRequestToEntity(request);
	         vehicleRepository.save(vehicle);
	     }

	     @Override
	     public Vehicle getVehicleById(Integer id) {
	         return vehicleRepository.findById(id)
	                 .orElseThrow(() -> new RuntimeException("Vehicle not found"));
	     }

	     @Override
	     public void updateVehicle(Integer id, AddVehicleRequest request) {
	         Vehicle existing = vehicleRepository.findById(id)
	                 .orElseThrow(() -> new RuntimeException("Vehicle not found"));
	         Vehicle updated = mapRequestToEntity(request);
	         updated.setId(existing.getId());
	         vehicleRepository.save(updated);
	     }

	     private Vehicle mapRequestToEntity(AddVehicleRequest request) {
	         Vehicle vehicle = new Vehicle();
	         vehicle.setRegistrationNumber(request.getRegistrationNumber());
	         vehicle.setVin(request.getVin());
	         vehicle.setMake(request.getMake());
	         vehicle.setModel(request.getModel());
	         vehicle.setVariant(request.getVariant());
	         vehicle.setManufacturingYear(request.getManufacturingYear());
	         vehicle.setColor(request.getColor());
	         vehicle.setFuelType(request.getFuelType());
	         vehicle.setTransmissionType(request.getTransmissionType());
	         vehicle.setSeatingCapacity(request.getSeatingCapacity());
	         vehicle.setMileage(request.getMileage());
	         vehicle.setDailyRentalPrice(request.getDailyRentalPrice());
	         vehicle.setHourlyRentalPrice(request.getHourlyRentalPrice());
	         vehicle.setStatus(request.getStatus());
	         vehicle.setAirConditioned(request.isAirConditioned());
	         vehicle.setGpsEnabled(request.isGpsEnabled());
	         vehicle.setMusicSystem(request.isMusicSystem());
	         vehicle.setAutomaticLock(request.isAutomaticLock());
	         vehicle.setVehicleType(request.getVehicleType());
	         vehicle.setEngineCapacity(request.getEngineCapacity());
	         vehicle.setCurrentOdometer(request.getCurrentOdometer());
	         vehicle.setLastServiceDate(request.getLastServiceDate());
	         vehicle.setInsuranceExpiryDate(request.getInsuranceExpiryDate());
	         vehicle.setDescription(request.getDescription());
	         vehicle.setActive(request.isActive());

	         Storage storage = storageRepository.findById(request.getStorageId())
	                 .orElseThrow(() -> new RuntimeException("Storage not found"));
	         vehicle.setStorage(storage);

	         if (request.getReservationId() != null) {
	             Reservation reservation = reservationRepository.findById(request.getReservationId())
	                     .orElseThrow(() -> new RuntimeException("Reservation not found"));
	             vehicle.setReservation(reservation);
	         }

	         return vehicle;
	     }
}
