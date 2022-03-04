package com.flightapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.Airline;
import com.flightapp.services.AirlineService;

@RestController
public class AirlineController {
	
	@Autowired
	private AirlineService airlineService;
	
	@GetMapping("/airlines")
	public List<Airline> getAllAirlines()
	{
		return airlineService.getAllAirlines();
	}

	@PostMapping("/airlines")
	public Airline saveAirline(@RequestBody Airline a)
	{
		return airlineService.saveAirline(a);
	}
	
	@GetMapping("/airlines/block/{id}")
	public Airline blockAirlines(@PathVariable int id)
	{
		return airlineService.updateStatus(id);
	}
}
