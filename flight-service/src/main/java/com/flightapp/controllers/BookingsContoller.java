package com.flightapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public BookingDetails getBookingsByPnr(@PathVariable int pnr) {
		return bookingsService.getdetailsByPnr(pnr);
	}

	@GetMapping("/byuserid/{id}")
	public List<BookingDetails> getBookingsByUserID(@PathVariable int id) {
		return bookingsService.getdetailsByUsrId(id);
	}

	@PutMapping("/cancel/{pnr}")
	public void cancelBooking(@PathVariable int pnr) {
		bookingsService.cancelBooking(pnr);
	}

	@PostMapping("/book")
	public void bookTicket(@RequestBody BookingDetails bookingdetails) {
		bookingsService.bookTickets(bookingdetails);
	}

	@GetMapping("/isflightusing/{flightid}")
	public boolean checkFlightUsability(@PathVariable int flightid) {
		long count = bookingsService.checkBookingFlightCount(flightid);
		if (count > 0) {
			return true;
		}
		return false;
	}

}
