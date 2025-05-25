package com.carrental.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrental.reservation.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Integer>{

}
