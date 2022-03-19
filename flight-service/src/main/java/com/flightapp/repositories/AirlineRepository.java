package com.flightapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flightapp.entities.Airline;

public interface AirlineRepository extends JpaRepository<Airline, Integer> {

	@Query("Select code from Airline")
	List<String> getAllAirlineCodes();
}
