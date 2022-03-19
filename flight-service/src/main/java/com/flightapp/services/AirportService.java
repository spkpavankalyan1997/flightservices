package com.flightapp.services;

import java.util.List;

import com.flightapp.entities.Airport;

public interface AirportService {

	int saveAirport(Airport airport);

	void deleteAirport(int id);
	
	List<Airport> getAirports();

}
