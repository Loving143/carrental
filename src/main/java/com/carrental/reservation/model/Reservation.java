package com.carrental.reservation.model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.carrental.Payment.model.Payment;
import com.carrental.enumm.ReservationStatus;
import com.carrental.reservation.dto.ReservationRequest;
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
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private CustomUser user;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "car_id")
	private Vehicle car;

	@OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
	private List<Payment> payments = new ArrayList<>();
	
	public Reservation(ReservationRequest request) {
		this.rentalStartDate = request.getRentalStartDate();
		this.rentalEndDate = request.getRentalEndDate();
		this.status= request.getStatus();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getReservationDateTime() {
		return reservationDateTime;
	}

	public void setReservationDateTime(LocalDateTime reservationDateTime) {
		this.reservationDateTime = reservationDateTime;
	}

	public LocalDate getRentalStartDate() {
		return rentalStartDate;
	}

	public void setRentalStartDate(LocalDate rentalStartDate) {
		this.rentalStartDate = rentalStartDate;
	}

	public LocalDate getRentalEndDate() {
		return rentalEndDate;
	}

	public void setRentalEndDate(LocalDate rentalEndDate) {
		this.rentalEndDate = rentalEndDate;
	}

	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}

	public CustomUser getUser() {
		return user;
	}

	public void setUser(CustomUser user) {
		this.user = user;
	}

	public Vehicle getCar() {
		return car;
	}

	public void setCar(Vehicle car) {
		this.car = car;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

}

