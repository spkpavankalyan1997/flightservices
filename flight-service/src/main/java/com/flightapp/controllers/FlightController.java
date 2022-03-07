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

import com.flightapp.entities.Flight;
import com.flightapp.services.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightController {

	@Autowired
	private FlightService flightService;

	@GetMapping("")
	private List<Flight> getAllFlights() {
		return flightService.getAllFlights();
	}

	@PostMapping
	private int saveFlight(@RequestBody Flight flight) {
		return flightService.saveFlight(flight);
	}

	@PutMapping("/cancelflight/{id}")
	private void cancelFlight(@PathVariable int id) {
		flightService.updateStatus(id);
	}

	@PostMapping("/updateflight")
	private void updateFlight(@RequestBody Flight flight) {
		flightService.updateFlight(flight);
	}
}
