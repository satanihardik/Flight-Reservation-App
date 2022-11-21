package com.hardik.flightreservation.services;

import com.hardik.flightreservation.dto.ReservationRequest;
import com.hardik.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
