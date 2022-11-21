package com.hardik.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardik.flightreservation.dto.ReservationRequest;
import com.hardik.flightreservation.entities.Flight;
import com.hardik.flightreservation.entities.Passenger;
import com.hardik.flightreservation.entities.Reservation;
import com.hardik.flightreservation.repos.FlightRepository;
import com.hardik.flightreservation.repos.PassengerRepository;
import com.hardik.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository; 

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
	
		Long flightId = request.getFlightId();    //take flightId from the user
		Flight flight = flightRepository.findById(flightId).get();
		
		Passenger passenger = new Passenger();  //Create new passenger object to save information in to passengerRepository databse
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		Passenger savedPassenger = passengerRepository.save(passenger); //save passenger info in to passenger table in database and assign it to new local variable.
		
		Reservation reservation = new Reservation();  //create reservation object to save reservation of given passenger in to reservation table in to the database.
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setcheckedIn(false);
		
		Reservation savedReservation = reservationRepository.save(reservation);  //saved reservation in to the reservation table 
		
		
		return savedReservation;
	}

}
