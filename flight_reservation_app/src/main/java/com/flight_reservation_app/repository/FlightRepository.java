package com.flight_reservation_app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flight_reservation_app.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture ") //this annotation helps us to design how you want to perform search operation
	List<Flight> findFlights(@Param("departureCity") String from, 
			@Param("arrivalCity")String to, 
			@Param("dateOfDeparture")Date departureDate);
	//@Param:- when u pass value to this methods with the help of param the values are copied into respective names given out here and then that values are used in place =:"fieldname" here to search in  database
}
