package com.flightapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.Airline;
import com.flightapp.services.AirlineService;

@RestController
@RequestMapping("/airlines")
public class AirlineController {

	@Autowired
	private AirlineService airlineService;

	@GetMapping("")
	public List<Airline> getAllAirlines() {
		return airlineService.getAllAirlines();
	}

	@PostMapping
	public int saveAirline(@RequestBody Airline airline) {
		return airlineService.saveAirline(airline);
	}

	@PutMapping("/block/{airlineid}")
	public void blockAirlines(@PathVariable int airlineid) {
		airlineService.updateStatus(airlineid);
	}
}
