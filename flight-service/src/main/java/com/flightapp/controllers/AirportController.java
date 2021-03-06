package com.flightapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.Airport;
import com.flightapp.services.AirportService;

@RestController
@CrossOrigin
@RequestMapping("/airports")
public class AirportController {
	
	@Autowired
	private AirportService airportService;
	
	@PostMapping
	public int saveAirport(@RequestBody Airport airport)
	{
		return airportService.saveAirport(airport);
	}
	
	@GetMapping("")
	public List<Airport> getAirports()
	{
		return airportService.getAirports();
	}
	
	@DeleteMapping("/{id}")
	public void deleteAirport(@PathVariable int id)
	{
		 airportService.deleteAirport(id);
	}

}
