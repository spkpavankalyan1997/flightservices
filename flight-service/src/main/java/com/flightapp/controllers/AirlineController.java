package com.flightapp.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin
public class AirlineController {

	@Autowired
	private AirlineService airlineService;

	@GetMapping("")
	public List<Airline> getAllAirlines() {
		return airlineService.getAllAirlines();
	}
	
	@GetMapping("/{id}")
	public Airline getAirlines(@PathVariable int id) {
		return airlineService.getAirline(id);
	}

	@PostMapping
	public int saveAirline(@RequestBody Airline airline) {
		return airlineService.saveAirline(airline);
	}

	@GetMapping("/block/{id}")
	public void blockAirlines(@PathVariable int id) {
		airlineService.updateStatus(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAirline(@PathVariable int id) {
		airlineService.deleteAirline(id);
	}
	
	@PutMapping
	public void updateAirline(@RequestBody Airline airline ) {
		airlineService.updateAirline(airline);
	}
	
	@GetMapping("/codes")
	public List<String> getAirlineCodes()
	{
		return airlineService.getAirlineCodes();
	}
}
