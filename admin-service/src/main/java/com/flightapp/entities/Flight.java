package com.flightapp.entities;

import java.time.LocalDateTime;

public class Flight {

	private int id;

	private String airlineCode;

	private String fromCity;

	private String toCity;

	private int businessSeats;

	private int nonBusinessSeats;

	private LocalDateTime fromTime;

	private LocalDateTime toTime;

	private double businessClassPrice;

	private double NonBusinessClassPrice;

	private String[] mealTypes;

	private int noofRows = 0;

	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public int getBusinessSeats() {
		return businessSeats;
	}

	public void setBusinessSeats(int businessSeats) {
		this.businessSeats = businessSeats;
	}

	public int getNonBusinessSeats() {
		return nonBusinessSeats;
	}

	public void setNonBusinessSeats(int nonBusinessSeats) {
		this.nonBusinessSeats = nonBusinessSeats;
	}

	public LocalDateTime getFromTime() {
		return fromTime;
	}

	public void setFromTime(LocalDateTime fromTime) {
		this.fromTime = fromTime;
	}

	public LocalDateTime getToTime() {
		return toTime;
	}

	public void setToTime(LocalDateTime toTime) {
		this.toTime = toTime;
	}

	public double getBusinessClassPrice() {
		return businessClassPrice;
	}

	public void setBusinessClassPrice(double businessClassPrice) {
		this.businessClassPrice = businessClassPrice;
	}

	public double getNonBusinessClassPrice() {
		return NonBusinessClassPrice;
	}

	public void setNonBusinessClassPrice(double nonBusinessClassPrice) {
		NonBusinessClassPrice = nonBusinessClassPrice;
	}

	public String[] getMealTypes() {
		return mealTypes;
	}

	public void setMealTypes(String[] mealTypes) {
		this.mealTypes = mealTypes;
	}

	public int getNoofRows() {
		return noofRows;
	}

	public void setNoofRows(int noofRows) {
		this.noofRows = noofRows;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
