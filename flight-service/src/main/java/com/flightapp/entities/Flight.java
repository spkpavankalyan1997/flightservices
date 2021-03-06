package com.flightapp.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Flight")
@Table(name = "Flight")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String airlineCode;

	@Column(nullable = false)
	private String fromCity;

	@Column(nullable = false)
	private String toCity;

	@Column(nullable = false)
	private int businessSeats;

	@Column(nullable = false)
	private int nonBusinessSeats;

	@Column(nullable = false)
	private LocalDateTime fromTime;

	@Column(nullable = false)
	private LocalDateTime toTime;

	@Column(nullable = false)
	private double businessClassPrice;

	@Column(nullable = false)
	private double nonBusinessClassPrice;

	@Column(nullable = false)
	private int noofRows = 0;

	@Column(nullable = false, updatable = true)
	private String status="";

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

	public void setBusinessSeats(int busiSeats) {
		this.businessSeats = busiSeats;
	}

	public int getNonBusinessSeats() {
		return nonBusinessSeats;
	}

	public void setNonBusinessSeats(int nbSeats) {
		this.nonBusinessSeats = nbSeats;
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

	public void setBusinessClassPrice(double busiClassPrice) {
		this.businessClassPrice = busiClassPrice;
	}

	public double getNonBusinessClassPrice() {
		return nonBusinessClassPrice;
	}

	public void setNonBusinessClassPrice(double nonBusiClassPrice) {
		nonBusinessClassPrice = nonBusiClassPrice;
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
