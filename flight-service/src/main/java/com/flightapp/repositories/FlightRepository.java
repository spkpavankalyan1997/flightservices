package com.flightapp.repositories;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flightapp.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	@Transactional
	@Modifying
	@Query("update Flight f set f.status=:status where f.airlineCode=:airlineCode")
	void updateBlockedStatus(@Param("status") String status, @Param("airlineCode") String code);

	@Transactional
	@Modifying
	@Query("update Flight f set f.status=:status where f.id=:id")
	void updateCancelledStatus(@Param("status") String status, @Param("id") int id);

	@Query("from Flight f where f.fromCity=:fromCity and f.toCity=:toCity and f.status not in ('BLOCKED','CANCELLED') and f.fromTime>=:selectedDate and f.fromTime>=:todayDate")
	List<Flight> getSearchedFlights(@Param("fromCity") String fromCity, @Param("toCity") String toCity,
			@Param("selectedDate") LocalDateTime selectedDate,@Param("todayDate") LocalDateTime todayDate);

	@Query("from Flight f where f.status not in ('BLOCKED','CANCELLED') and f.fromTime>=:todayDate")
	List<Flight> getAllFlights(@Param("todayDate") LocalDateTime todayDate);
}
