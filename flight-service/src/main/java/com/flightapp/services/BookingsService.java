package com.flightapp.services;

import java.util.List;

import com.flightapp.entities.BookingDetails;

public interface BookingsService {

	List<BookingDetails> getdetailsByPnr(int pnr);

	List<BookingDetails> getdetailsByUsrId(int id);

	void cancelBooking(int pnr);

	void bookTickets(int id);

}
