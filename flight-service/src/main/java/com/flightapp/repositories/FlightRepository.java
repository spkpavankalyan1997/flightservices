package com.flightapp.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flightapp.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{

	@Transactional
	@Modifying
	@Query("update Flight f set f.status=:status where f.airlineCode=:airlineCode")
	void updateBlockedStatus(@Param("status") String status,@Param("airlineCode") String code);
	
	@Transactional
	@Modifying
	@Query("update Flight f set f.status=:status where f.id=:id")
	void updateCancelledStatus(@Param("status") String status,@Param("id") int id);
}
