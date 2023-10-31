package com.flight_reservation_app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight_reservation_app.dto.ReservationUpdateRequest;
import com.flight_reservation_app.entity.Reservation;
import com.flight_reservation_app.repository.ReservationRepository;

@RestController //this make this class as Rest controller it converts the java object to JSON object and JSON object back to java object
public class ReservationRestController {
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	//http://localhost:8080/fligths/reservation/1
		
		@RequestMapping("/reservation/{id}") //with the URL's we are interacting with databases
		public Reservation findReservation(@PathVariable("id") long id) {
			Optional<Reservation> findById = reservationRepo.findById(id);
			Reservation reservation = findById.get();			
			return reservation;//here we are returning entity class or java class object converted to JSON object because of @RestCOntroller
		}
		
		//@RequestBody :- this annotation binds the JSON object  data into java object
		//http://localhost:8080/flights/reservation
		//using this url we can update checkedIn status and no-of-bags
		@RequestMapping("/reservation") //post opreation
		public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {//it automatically takes the form data to ReservationUpdateRequest class
			Optional<Reservation> findById = reservationRepo.findById(request.getId());//using resquest reference  get id
			Reservation reservation = findById.get();//based on id we get reservation details
			reservation.setCheckedIn(request.isCheckedIn());//in that reservation obj i need to change the values of chckedin and noofbags
			reservation.setNumberOfBags(request.getNumberOfBags());
			return reservationRepo.save(reservation);
		}
}
