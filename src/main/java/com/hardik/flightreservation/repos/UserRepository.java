package com.hardik.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hardik.flightreservation.entities.User;

public interface UserRepository extends JpaRepository< User, Long> {

	User findByEmail(String email); //Due to spring DATA we need not write a single query here.
	                                //By getting the email springdata automatically generate the query for us , select * from user table

}
