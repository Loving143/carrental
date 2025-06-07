package com.carrental.reservation.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;

import com.carrental.exception.BadRequestException;
import com.carrental.reservation.dto.ReservationRequest;
import com.carrental.reservation.model.Reservation;
import com.carrental.reservation.repository.ReservationRepository;
import com.carrental.reservation.service.ReservationService;
import com.carrental.security.model.CustomUser;
import com.carrental.security.repository.CustomerRepository;
import com.carrental.util.Address;
import com.carrental.vehicle.model.Vehicle;
import com.carrental.vehicle.repository.VehicleRepository;

public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private VehicleRepository vehicleRepo;
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Override
	public void addReservation(ReservationRequest request) {
		Reservation reservation = new Reservation(request);
		CustomUser customer = custRepo.findById(request.getUserId()).
				orElseThrow(()->new BadRequestException("User with id "+request.getUserId()+" does not exists!"));
		Vehicle vehicle = vehicleRepo.findById(request.getVehicleId()).
				orElseThrow(()-> new BadRequestException("Vehicle with vehicle id "+request.getVehicleId()+"does not exists!"));
		Address address = new Address(request.getAddress());
		customer.setAddress(address);
		reservation.setCar(vehicle);
		reservation.setUser(customer);
		reservationRepo.save(reservation);
	}

}
