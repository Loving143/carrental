package com.carrental.reservation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrental.reservation.dto.ReservationRequest;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@PostMapping("/add")
	public ResponseEntity<?>addReservation(@RequestBody ReservationRequest request){
		return null;
	}
}
