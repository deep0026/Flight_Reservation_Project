package com.flight_reservation_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flight_reservation_app.dto.ReservationRequest;
import com.flight_reservation_app.entity.Reservation;

import com.flight_reservation_app.service.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	//To deal with multiple table we need to create service layer
	@RequestMapping("/completeReservation")
	public String completeReservation(ReservationRequest reservation,ModelMap modelMap) {
		Reservation reservationId = reservationService.bookFlight(reservation);
		modelMap.addAttribute("reservationId",reservationId.getId());
		
		return "confirmReservation";
	}
}
