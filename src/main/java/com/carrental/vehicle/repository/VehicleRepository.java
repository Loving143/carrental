package com.carrental.vehicle.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.carrental.enumm.FuelType;
import com.carrental.enumm.TransmissionType;
import com.carrental.vehicle.model.Vehicle;
import com.carrental.vehicle.response.VehicleResponsible;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{

	boolean existsByRegistrationNumber(String registrationNumber);

	@Query("Select  "
			+ " v.model as model,"
			+ " v.fuelType as fuelType,"
			+ " v.seatingCapacity as seatingCapacity,"
			+ " v.mileage as mileage,"
			+ " v.transmissionType as transmissionType, "
			+ " v.dailyRentalPrice as dailyRentalPrice,"
			+ " v.hourlyRentalPrice as hourlyRentalPrice,"
			+ " v.vehicleType as vehicleType,"
			+ " v.gpsEnabled as gpsEnabled,"
			+ " v.airConditioned as airConditioned"
			+ " from Vehicle as v "
			+ " where v.model=:model "
			+ " AND v.active = true ")
	List<VehicleResponsible> fetchVehiclesByModel(String model);

	@Query("Select  "
			+ " v.model as model,"
			+ " v.fuelType as fuelType,"
			+ " v.seatingCapacity as seatingCapacity,"
			+ " v.mileage as mileage,"
			+ " v.transmissionType as transmissionType, "
			+ " v.dailyRentalPrice as dailyRentalPrice,"
			+ " v.hourlyRentalPrice as hourlyRentalPrice,"
			+ " v.vehicleType as vehicleType,"
			+ " v.gpsEnabled as gpsEnabled,"
			+ " v.airConditioned as airConditioned"
			+ " from Vehicle as v "
			+ " where (v.hourlyRentalPrice =:price  OR "
			+ " v.dailyRentalPrice =:price ) "
			+ " AND v.active = true ")
	List<VehicleResponsible> fetchVehiclesByPrice(String price);

	@Query("Select  "
			+ " v.model as model,"
			+ " v.fuelType as fuelType,"
			+ " v.seatingCapacity as seatingCapacity,"
			+ " v.mileage as mileage,"
			+ " v.transmissionType as transmissionType, "
			+ " v.dailyRentalPrice as dailyRentalPrice,"
			+ " v.hourlyRentalPrice as hourlyRentalPrice,"
			+ " v.vehicleType as vehicleType,"
			+ " v.gpsEnabled as gpsEnabled,"
			+ " v.airConditioned as airConditioned"
			+ " from Vehicle as v "
			+ " where v.transmissionType = :transmissionType"
			+ " AND v.active = true ")
	List<VehicleResponsible> fetchVehicleByTransmissionType(TransmissionType transmissionType);

	@Query("Select  "
			+ " v.model as model,"
			+ " v.fuelType as fuelType,"
			+ " v.seatingCapacity as seatingCapacity,"
			+ " v.mileage as mileage,"
			+ " v.transmissionType as transmissionType, "
			+ " v.dailyRentalPrice as dailyRentalPrice,"
			+ " v.hourlyRentalPrice as hourlyRentalPrice,"
			+ " v.vehicleType as vehicleType,"
			+ " v.gpsEnabled as gpsEnabled,"
			+ " v.airConditioned as airConditioned"
			+ " from Vehicle as v "
			+ " where v.brand = :brand "
			+ " AND v.active = true ")
	List<VehicleResponsible> fetchVehiclesByBrand(String brand);

	@Query("Select  "
			+ " v.model as model,"
			+ " v.fuelType as fuelType,"
			+ " v.seatingCapacity as seatingCapacity,"
			+ " v.mileage as mileage,"
			+ " v.transmissionType as transmissionType, "
			+ " v.dailyRentalPrice as dailyRentalPrice,"
			+ " v.hourlyRentalPrice as hourlyRentalPrice,"
			+ " v.vehicleType as vehicleType,"
			+ " v.gpsEnabled as gpsEnabled,"
			+ " v.airConditioned as airConditioned"
			+ " from Vehicle as v "
			+ " where v.color = :color "
			+ " AND v.active = true ")
	List<VehicleResponsible> fetchVehiclesByColor(String color);

	@Query("Select  "
			+ " v.model as model,"
			+ " v.fuelType as fuelType,"
			+ " v.seatingCapacity as seatingCapacity,"
			+ " v.mileage as mileage,"
			+ " v.transmissionType as transmissionType, "
			+ " v.dailyRentalPrice as dailyRentalPrice,"
			+ " v.hourlyRentalPrice as hourlyRentalPrice,"
			+ " v.vehicleType as vehicleType,"
			+ " v.gpsEnabled as gpsEnabled,"
			+ " v.airConditioned as airConditioned "
			+ " from Vehicle as v "
			+ " where v.fuelType = :fuelType "
			+ " AND v.active = true ")
	List<VehicleResponsible> fetchVehicleByFuelType(FuelType fuelType);

	@Query("Select  "
			+ " v.model as model,"
			+ " v.fuelType as fuelType,"
			+ " v.seatingCapacity as seatingCapacity,"
			+ " v.mileage as mileage,"
			+ " v.transmissionType as transmissionType, "
			+ " v.dailyRentalPrice as dailyRentalPrice,"
			+ " v.hourlyRentalPrice as hourlyRentalPrice,"
			+ " v.vehicleType as vehicleType,"
			+ " v.gpsEnabled as gpsEnabled,"
			+ " v.airConditioned as airConditioned"
			+ " from Vehicle as v "
			+ " where v.id IN :carIds "
			+ " AND v.active = true ")
	List<VehicleResponsible> compareVehicles(List<Integer> carIds);

}
