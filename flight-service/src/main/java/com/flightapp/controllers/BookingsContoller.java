package com.flightapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.BookingDetails;
import com.flightapp.services.BookingsService;

@RestController
@CrossOrigin
public class BookingsContoller {

	@Autowired
	private BookingsService bookingsService;
	
	@GetMapping("/bookings/bypnr/{pnr}")
	public List<BookingDetails> getBookingsByPnr(@PathVariable int pnr)
	{
		return bookingsService.getdetailsByPnr(pnr);
	}
	
	@GetMapping("/bookings/byuserid/{id}")
	public List<BookingDetails> getBookingsByUserID(@PathVariable int id)
	{
		return bookingsService.getdetailsByUsrId(id);
	}
	
	@GetMapping("/bookings/cancel/{pnr}")
	public String cancelBooking(@PathVariable int pnr)
	{
		return bookingsService.cancelBooking(pnr);
	}
	
	@GetMapping("/bookings/book/{flightID}")
	public String bookTicket(@PathVariable int flightID)
	{
		return bookingsService.bookTickets(flightID);
	}
	
}
