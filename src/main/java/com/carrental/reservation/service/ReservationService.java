package com.carrental.reservation.service;

import com.carrental.reservation.dto.ReservationRequest;
import com.carrental.reservation.response.BookingPreviewResponse;

public interface ReservationService {

	void addReservation(ReservationRequest request);
	BookingPreviewResponse fetchBookingPreview(Integer reservationId);

}
