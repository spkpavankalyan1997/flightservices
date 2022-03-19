package com.flightapp.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flightapp.entities.BookingDetails;

public interface BookingsRepository extends JpaRepository<BookingDetails, Integer> {

	List<BookingDetails> findByuserID(int userID);

	@Transactional
	@Modifying
	@Query("update BookingDetails b set b.status=:status where b.pnr=:pnr")
	void updateCancelledStatus(@Param("status") String status, @Param("pnr") int pnr);

	long countByflightID(@Param("flightId") int flightId);

}
