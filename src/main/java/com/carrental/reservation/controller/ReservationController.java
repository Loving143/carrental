package com.carrental.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrental.reservation.dto.ReservationRequest;
import com.carrental.reservation.service.ReservationService;
import com.carrental.response.ResponseMessage;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@PostMapping("/add")
	public ResponseEntity<?>addReservation(@RequestBody ReservationRequest request){
		reservationService.addReservation(request);
		return  ResponseEntity.ok(new ResponseMessage("1","Booking done successfully!"));
	}
	
	@GetMapping("/reservation-preview/{reservationId}")
	public ResponseEntity<?>bookingPreview(@PathVariable Integer reservationId){
		return ResponseEntity.ok(new ResponseMessage("1",reservationService.fetchBookingPreview(reservationId)));
	}
	
	
}
