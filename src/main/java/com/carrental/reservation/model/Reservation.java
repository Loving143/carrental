package com.carrental.reservation.model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.carrental.Payment.model.Payment;
import com.carrental.enumm.ReservationStatus;
import com.carrental.security.model.CustomUser;
import com.carrental.vehicle.model.Vehicle;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Reservation{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDateTime reservationDateTime; // When the reservation was made
	
	private LocalDate rentalStartDate;   // Rental start
	private LocalDate rentalEndDate;     // Rental end
	
	private ReservationStatus status; // Enum: PENDING, CONFIRMED, CANCELLED, REVIEWING
	@ManyToOne
	@JoinColumn(name = "user_id")
	private CustomUser user;

	@ManyToOne
	@JoinColumn(name = "car_id")
	private Vehicle car;

	@OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
	private List<Payment> payments = new ArrayList<>();

}

