package com.flight_reservation_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight_reservation_app.dto.ReservationRequest;
import com.flight_reservation_app.entity.Flight;
import com.flight_reservation_app.entity.Passenger;
import com.flight_reservation_app.entity.Reservation;
import com.flight_reservation_app.repository.FlightRepository;
import com.flight_reservation_app.repository.PassengerRepository;
import com.flight_reservation_app.repository.ReservationRepository;
import com.flight_reservation_app.utilities.EmailUtil;
import com.flight_reservation_app.utilities.PdfGenerator;


@Service
public class ReservationServiceImpl implements ReservationService {

	//Here we need to deal with multiple table of database
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	
	
	@Autowired
	private PdfGenerator pdfGenerator;//sterio type when creating a bean for a java class using @Autowired for that we need to mark that class with @Component annotation 
	
	@Autowired
	private EmailUtil emailUtil;
	
	
	@Override
	public Reservation bookFlight(ReservationRequest reservation) {
		
		
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(reservation.getFirstName());
		passenger.setLastName(reservation.getLastName());
		passenger.setMiddleName(reservation.getMiddleName());
		passenger.setEmail(reservation.getEmail());
		passenger.setPhone(reservation.getPhone());
		passengerRepo.save(passenger);
		
		long flightId = reservation.getFlightId();//here we are not saving flight details we are only getting flight object
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		
		Reservation reserv = new Reservation();
		reserv.setFlight(flight);//automatically flightId saved in reservation table
		reserv.setPassenger(passenger);//automatically PassengerId saved in reservation table
		reserv.setCheckedIn(false);
		reserv.setNumberOfBags(0);
		String filePath="F:\\sts5May2023\\flight_reservation_app\\tickets\\"+reserv.getId()+".pdf";
		reservationRepo.save(reserv);
		
		
		//PdfGenerator pdf =new PdfGenerator();//this will helps us to call the pdf generator method present in pdfGenerator class
		pdfGenerator.generatePDF(filePath+reserv.getId()+".pdf", reservation.getFirstName(), reservation.getEmail(), reservation.getPhone(), flight.getOperatingAirlines(),
				flight.getDateOfDeparture(), flight.getDepartureCity(), flight.getArrivalCity());
		
		String attachment = filePath+reserv.getId()+".pdf";
		emailUtil.sendItinerary(reservation.getEmail(), attachment);
		return reserv;
	}

}
