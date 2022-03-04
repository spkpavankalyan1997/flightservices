package com.flightapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entities.Flight;
import com.flightapp.repositories.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;

	public List<Flight> getAllFlights() {
		return flightRepository.findAll();
	}

	public Flight saveFlight(Flight f) {
		return flightRepository.save(f);
	}

	public Flight updateStatus(int id) {
		Flight f = new Flight();
		Optional<Flight> flight = flightRepository.findById(id);
		if (flight.isPresent()) {
			f = flight.get();
			f.setStatus("CANCELLED");
			flightRepository.updateCancelledStatus("CANCELLED", id);
			return f;
		}
		return f;
	}

	public Flight updateFlight(Flight flgt) {
		Flight f = new Flight();
		Optional<Flight> flight = flightRepository.findById(flgt.getFlightId());
		if (flight.isPresent()) {
			f = flgt;
			f = flightRepository.save(f);
			return f;
		}
		return f;
	}
}