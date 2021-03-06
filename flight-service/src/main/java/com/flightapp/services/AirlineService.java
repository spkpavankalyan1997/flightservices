package com.flightapp.services;

import java.util.List;

import com.flightapp.entities.Airline;

public interface AirlineService {

	List<Airline> getAllAirlines();

	int saveAirline(Airline airline);

	void updateStatus(int airlineid);
	
	Airline getAirline(int id);
	
	void deleteAirline(int id);
	
	void updateAirline(Airline airline);
	
	List<String> getAirlineCodes();

}
