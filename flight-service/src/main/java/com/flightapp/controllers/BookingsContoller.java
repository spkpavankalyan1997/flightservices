package com.flightapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.BookingDetails;
import com.flightapp.services.BookingsService;

@RestController
@CrossOrigin
@RequestMapping("/bookings")
public class BookingsContoller {

	@Autowired
	private BookingsService bookingsService;

	@GetMapping("/bypnr/{pnr}")
	public List<BookingDetails> getBookingsByPnr(@PathVariable int pnr) {
		return bookingsService.getdetailsByPnr(pnr);
	}

	@GetMapping("/byuserid/{id}")
	public List<BookingDetails> getBookingsByUserID(@PathVariable int id) {
		return bookingsService.getdetailsByUsrId(id);
	}

	@GetMapping("/cancel/{pnr}")
	public void cancelBooking(@PathVariable int pnr) {
		bookingsService.cancelBooking(pnr);
	}

	@GetMapping("/book/{id}")
	public void bookTicket(@PathVariable int id) {
		bookingsService.bookTickets(id);
	}

}
