package com.carrental.vehicle.model;

import java.time.LocalDate;

import com.carrental.enumm.FuelType;
import com.carrental.enumm.TransmissionType;
import com.carrental.enumm.VehicleStatus;
import com.carrental.enumm.VehicleType;
import com.carrental.reservation.model.Reservation;
import com.carrental.storage.model.Storage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private Storage storage;
	
	@OneToOne
	private Reservation reservation;
	@Column(unique = true, nullable = false)
    private String registrationNumber;     // Unique plate number
    private String vin;                    // Vehicle Identification Number
    private String make;                   // Brand (e.g., Toyota)
    private String model;                  // Model (e.g., Corolla)
    private String variant;                // Trim or version
    private int manufacturingYear;                      // Manufacturing year
    private String color;
     @Enumerated(EnumType.STRING)
    private FuelType fuelType; 
    @Enumerated(EnumType.STRING)
    private TransmissionType transmissionType;     
    private int seatingCapacity;
    private double mileage;          
    private double dailyRentalPrice;
    private double hourlyRentalPrice;
    
    @Enumerated(EnumType.STRING)
    private VehicleStatus status;  

    private boolean airConditioned;
    private boolean gpsEnabled;
    private boolean musicSystem;
    private boolean automaticLock;
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;           // SUV, Sedan, Hatchback, etc.
    private double engineCapacity;        // in CC
    private double currentOdometer;       // in km
    private LocalDate lastServiceDate;
    private LocalDate insuranceExpiryDate;            // City or branch
    private String description;
    private boolean active;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public int getManufacturingYear() {
		return manufacturingYear;
	}

	public void setManufacturingYear(int manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public TransmissionType getTransmissionType() {
		return transmissionType;
	}

	public void setTransmissionType(TransmissionType transmissionType) {
		this.transmissionType = transmissionType;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public double getDailyRentalPrice() {
		return dailyRentalPrice;
	}

	public void setDailyRentalPrice(double dailyRentalPrice) {
		this.dailyRentalPrice = dailyRentalPrice;
	}

	public double getHourlyRentalPrice() {
		return hourlyRentalPrice;
	}

	public void setHourlyRentalPrice(double hourlyRentalPrice) {
		this.hourlyRentalPrice = hourlyRentalPrice;
	}

	public VehicleStatus getStatus() {
		return status;
	}

	public void setStatus(VehicleStatus status) {
		this.status = status;
	}

	public boolean isAirConditioned() {
		return airConditioned;
	}

	public void setAirConditioned(boolean airConditioned) {
		this.airConditioned = airConditioned;
	}

	public boolean isGpsEnabled() {
		return gpsEnabled;
	}

	public void setGpsEnabled(boolean gpsEnabled) {
		this.gpsEnabled = gpsEnabled;
	}

	public boolean isMusicSystem() {
		return musicSystem;
	}

	public void setMusicSystem(boolean musicSystem) {
		this.musicSystem = musicSystem;
	}

	public boolean isAutomaticLock() {
		return automaticLock;
	}

	public void setAutomaticLock(boolean automaticLock) {
		this.automaticLock = automaticLock;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public double getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(double engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public double getCurrentOdometer() {
		return currentOdometer;
	}

	public void setCurrentOdometer(double currentOdometer) {
		this.currentOdometer = currentOdometer;
	}

	public LocalDate getLastServiceDate() {
		return lastServiceDate;
	}

	public void setLastServiceDate(LocalDate lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}

	public LocalDate getInsuranceExpiryDate() {
		return insuranceExpiryDate;
	}

	public void setInsuranceExpiryDate(LocalDate insuranceExpiryDate) {
		this.insuranceExpiryDate = insuranceExpiryDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
