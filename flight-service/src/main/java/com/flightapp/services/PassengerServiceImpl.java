package com.flightapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entities.Passenger;
import com.flightapp.repositories.PassengerRepository;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepository passengerRepository;

	public List<Passenger> getPassengersByPnr(int pnr) {
		return passengerRepository.findByPnr(pnr);
	}

}
