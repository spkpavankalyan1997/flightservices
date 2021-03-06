package com.flightapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.constants.FlightServiceStatus;
import com.flightapp.entities.Airline;
import com.flightapp.repositories.AirlineRepository;
import com.flightapp.repositories.FlightRepository;

@Service
public class AirlineServiceImpl implements AirlineService {

	@Autowired
	private AirlineRepository airlineRepository;

	@Autowired
	private FlightRepository flightRepository;

	public List<Airline> getAllAirlines() {
		return airlineRepository.findAll();
	}

	public int saveAirline(Airline airline) {
		return airlineRepository.save(airline).getId();
	}

	public void updateStatus(int airlineid) {
		Optional<Airline> airline = airlineRepository.findById(airlineid);
		if (airline.isPresent()) {
			String status = FlightServiceStatus.BLOCKED.name();
			airline.get().setStatus(status);
			flightRepository.updateBlockedStatus(status, airline.get().getCode());
			airlineRepository.save(airline.get());
		}
	}

	@Override
	public Airline getAirline(int id) {

		Optional<Airline> airline = airlineRepository.findById(id);

		if (airline.isPresent()) {
			return airline.get();
		}
		return new Airline();
	}

	@Override
	public void deleteAirline(int id) {
		airlineRepository.deleteById(id);

	}

	@Override
	public void updateAirline(Airline airline) {
		Optional<Airline> airlines = airlineRepository.findById(airline.getId());
		if (airlines.isPresent()) {
			airlineRepository.save(airline);
		}
	}

	@Override
	public List<String> getAirlineCodes() {
		
		return airlineRepository.getAllAirlineCodes();
	}

}
