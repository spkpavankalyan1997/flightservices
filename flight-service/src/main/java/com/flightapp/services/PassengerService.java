package com.flightapp.services;

import java.util.List;

import com.flightapp.entities.Passenger;

public interface PassengerService {

	List<Passenger> getPassengersByPnr(int pnr);

}
