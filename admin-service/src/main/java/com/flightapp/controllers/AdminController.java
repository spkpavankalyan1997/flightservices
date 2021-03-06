package com.flightapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightapp.entities.Airline;
import com.flightapp.entities.Flight;

@RestController
public class AdminController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/airlines")
	private List<Airline> getAllAirlines() {
		ResponseEntity<List<Airline>> response = restTemplate.exchange("http://FLIGHT-SERVICE/airlines", HttpMethod.GET,
				new HttpEntity(null), new ParameterizedTypeReference<List<Airline>>() {
				});

		return response.getBody();
	}

	@PostMapping("/airlines")
	private int saveAirlines(@RequestBody Airline airline) {
		int id = restTemplate.postForObject("http://FLIGHT-SERVICE/airlines", airline, Integer.class);
		return id;
	}

	@GetMapping("/airlines/block/{id}")
	private void blockAirlines(@PathVariable int id) {
		restTemplate.getForObject("http://FLIGHT-SERVICE/airlines/block/{id}", Void.class, id);
	}

	@GetMapping("/flights")
	private List<Flight> getAllFlights() {
		ResponseEntity<List<Flight>> response = restTemplate.exchange("http://FLIGHT-SERVICE/flights", HttpMethod.GET,
				new HttpEntity(null), new ParameterizedTypeReference<List<Flight>>() {
				});

		return response.getBody();
	}

	@PostMapping("/flights")
	private int saveFlight(@RequestBody Flight flight) {
		int id = restTemplate.postForObject("http://FLIGHT-SERVICE/flights", flight, Integer.class);
		return id;
	}

	@PostMapping("/flights/updateflight")
	private void updateFlight(@RequestBody Flight flight) {
		restTemplate.postForObject("http://FLIGHT-SERVICE/flights/updateflight", flight, Void.class);
	}

	@GetMapping("/flights/cancelflight/{id}")
	private void cancelFlight(@PathVariable int id) {
		restTemplate.getForObject("http://FLIGHT-SERVICE/flights/cancelflight/{id}", Void.class, id);
	}

}
