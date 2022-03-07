package com.flightapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.constants.FlightServiceStatus;
import com.flightapp.entities.Flight;
import com.flightapp.repositories.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepository;

	public List<Flight> getAllFlights() {
		return flightRepository.findAll();
	}

	public int saveFlight(Flight flight) {
		return flightRepository.save(flight).getId();
	}

	public void updateStatus(int id) {
		Optional<Flight> flight = flightRepository.findById(id);
		if (flight.isPresent()) {
			flightRepository.updateCancelledStatus(FlightServiceStatus.CANCELLED.name(), id);
		}
	}

	public void updateFlight(Flight flight) {
		Optional<Flight> flight1 = flightRepository.findById(flight.getId());
		if (flight1.isPresent()) {
			flightRepository.save(flight);
		}
	}
}
