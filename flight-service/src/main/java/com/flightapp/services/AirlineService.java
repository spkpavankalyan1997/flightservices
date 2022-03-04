package com.flightapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.flightapp.entities.Airline;
import com.flightapp.repositories.AirlineRepository;
import com.flightapp.repositories.FlightRepository;

@Service
public class AirlineService {

	@Autowired
	private AirlineRepository airlineRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	public List<Airline> getAllAirlines()
	{
		return airlineRepository.findAll();
	}
	
	public Airline saveAirline(Airline a)
	{
		return airlineRepository.save(a);
	}
	

	public Airline updateStatus(int id)
	{
		Airline a=new Airline();
		Optional<Airline> airline=airlineRepository.findById(id);
		if(airline.isPresent())
		{
			a=airline.get();
			a.setStatus("BLOCKED");
			flightRepository.updateBlockedStatus("BLOCKED", a.getAirLineCode());
			return airlineRepository.save(a);
		}
		return a;
	}
	
}
