package com.hardik.flightreservation.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity  //JPA annotation
public class Reservation extends AbstractEntity {
	
	
	private Boolean checkedIn;
	private int numberOfBags;
	
	@OneToOne   //It is because this field is foreign key in database.
	private Passenger passenger;
	@OneToOne
	private Flight flight;

	public Boolean getcheckedIn() {
		return checkedIn;
	}
	public void setcheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	public int getNumberOfBags() {
		return numberOfBags;
	}
	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	

}
