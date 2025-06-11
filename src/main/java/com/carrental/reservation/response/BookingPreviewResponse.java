package com.carrental.reservation.response;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.carrental.reservation.model.Reservation;

public class BookingPreviewResponse {
	
	private String carName;
	private String fuelType;
	private String transmission;
	private String seats;
	private Double pricePerDay;
	private String email;
	private String mobile;
	private LocalDate rentalStartDate;
	private LocalDate rentalEndDate; 
	private Integer totalRentalDays;
	private Double rent;
	private Double tax;
	private Double discount;
	private Double totalAmount;
	
	public BookingPreviewResponse(Reservation reservation) {
		this.carName = reservation.getCar().getVehicleName();
		this.fuelType = reservation.getCar().getFuelType().name();
		this.transmission = reservation.getCar().getTransmissionType().name();
		this.seats = Integer.toString(reservation.getCar().getSeatingCapacity());
		this.pricePerDay = reservation.getCar().getDailyRentalPrice();
		this.email = reservation.getUser().getEmail();
		this.mobile = reservation.getUser().getPhoneNumber();
		this.rentalStartDate = reservation.getRentalStartDate();
		this.rentalEndDate = reservation.getRentalEndDate();
		this.rent =ChronoUnit.DAYS.between(reservation.getRentalStartDate(), reservation.getRentalEndDate())*reservation.getCar().getDailyRentalPrice();
	}
	
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public String getSeats() {
		return seats;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}
	public Double getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	public Integer getTotalRentalDays() {
		return totalRentalDays;
	}
	public void setTotalRentalDays(Integer totalRentalDays) {
		this.totalRentalDays = totalRentalDays;
	}
	public Double getRent() {
		return rent;
	}
	public void setRent(Double rent) {
		this.rent = rent;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	} 
	
}
