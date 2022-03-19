package com.flightapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.flightapp.constants.FlightServiceStatus;
import com.flightapp.entities.BookingDetails;
import com.flightapp.entities.Passenger;
import com.flightapp.repositories.BookingsRepository;
import com.flightapp.repositories.FlightRepository;
import com.flightapp.repositories.PassengerRepository;

@Service
public class BookingsServiceImpl implements BookingsService {

	@Autowired
	private BookingsRepository bookingsRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private FlightRepository flightRepository;

	public BookingDetails getdetailsByPnr(int pnr) {

		Optional<BookingDetails> bookingDetails = bookingsRepository.findById(pnr);

		if (bookingDetails.isPresent()) {
			List<Passenger> passengers = passengerRepository.findByPnr(bookingDetails.get().getPnr());
			if (!CollectionUtils.isEmpty(passengers)) {
				bookingDetails.get().setPassengers(passengers);
			}
			return bookingDetails.get();
		}
		return new BookingDetails();
		
	}

	public List<BookingDetails> getdetailsByUsrId(int id) {

		List<BookingDetails> bookingsList = bookingsRepository.findByuserID(id);

		return bookingsList;
	}

	public void cancelBooking(int pnr) {
		bookingsRepository.updateCancelledStatus(FlightServiceStatus.CANCELLED.name(), pnr);
	}

	public void bookTickets(BookingDetails bookingDetails) {

		BookingDetails bookingdetails = bookingsRepository.save(bookingDetails);
		if (!CollectionUtils.isEmpty(bookingDetails.getPassengers())) {
			bookingDetails.getPassengers().forEach(p -> p.setPnr(bookingdetails.getPnr()));
			Iterable<Passenger> list = bookingDetails.getPassengers();
			passengerRepository.saveAll(list);
		}

	}

	@Override
	public long checkBookingFlightCount(int flightId) {

		return bookingsRepository.countByflightID(flightId);
	}
}
