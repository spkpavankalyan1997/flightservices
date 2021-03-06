package com.flightapp.services;

import java.time.LocalDateTime;
import java.util.List;

import com.flightapp.entities.Flight;

public interface FlightService {

	List<Flight> getAllFlights();

	void updateStatus(int id);

	int saveFlight(Flight flight);

	void updateFlight(Flight flight);

	void deleteFlight(int id);

	List<Flight> getSearchedFlights(String fromCity, String toCity);
	
	Flight getFlight(int id);

	List<Flight> getSearchedFlights(String fromCity, String toCity, LocalDateTime selectedDate);

}
