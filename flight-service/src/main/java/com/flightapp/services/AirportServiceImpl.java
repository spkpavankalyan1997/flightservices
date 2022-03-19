package com.flightapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entities.Airport;
import com.flightapp.repositories.AirportRepository;

@Service
public class AirportServiceImpl implements AirportService {

	@Autowired
	private AirportRepository airportRepository;

	@Override
	public int saveAirport(Airport airport) {
		return airportRepository.save(airport).getId();
	}

	@Override
	public void deleteAirport(int id) {
		Optional<Airport> airport = airportRepository.findById(id);
		if (airport.isPresent()) {
			airportRepository.deleteById(id);
		}

	}

	@Override
	public List<Airport> getAirports() {
		
		return airportRepository.findAll();
	}

}
