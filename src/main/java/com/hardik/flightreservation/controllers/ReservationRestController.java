package com.hardik.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardik.flightreservation.dto.UpdateReservationRequest;
import com.hardik.flightreservation.entities.Reservation;
import com.hardik.flightreservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {
	@Autowired
	ReservationRepository reservationRepository;
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		Reservation reservation = reservationRepository.findById(id).get();
		return reservation;
		
	}
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody UpdateReservationRequest request) {
		Reservation reservation = reservationRepository.findById(request.getId()).get();
		reservation.setcheckedIn(request.getCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());
		Reservation updatedReservation = reservationRepository.save(reservation);
		
		return updatedReservation;
	}

}
