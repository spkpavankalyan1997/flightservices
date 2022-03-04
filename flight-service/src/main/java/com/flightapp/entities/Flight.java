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
	private int flightId;

	@Column(nullable = false)
	private String airLine;

	@Column(nullable = false)
	private String fromCity;

	@Column(nullable = false)
	private String toCity;

	@Column(nullable = false)
	private int busiSeats;

	@Column(nullable = false)
	private int nbSeats;

	@Column(nullable = false)
	private LocalDateTime fromTime;

	@Column(nullable = false)
	private LocalDateTime toTime;

	@Column(nullable = false)
	private double busiClassPrice;

	@Column(nullable = false)
	private double NonBusiClassPrice;

	@Column(nullable = false)
	private String meal;

	@Column(nullable = false)
	private int noofRows = 0;
	
	@Column(nullable = false,updatable =true)
	private String status;

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getAirLine() {
		return airLine;
	}

	public void setAirLine(String airLine) {
		this.airLine = airLine;
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

	public int getBusiSeats() {
		return busiSeats;
	}

	public void setBusiSeats(int busiSeats) {
		this.busiSeats = busiSeats;
	}

	public int getNbSeats() {
		return nbSeats;
	}

	public void setNbSeats(int nbSeats) {
		this.nbSeats = nbSeats;
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

	public double getBusiClassPrice() {
		return busiClassPrice;
	}

	public void setBusiClassPrice(double busiClassPrice) {
		this.busiClassPrice = busiClassPrice;
	}

	public double getNonBusiClassPrice() {
		return NonBusiClassPrice;
	}

	public void setNonBusiClassPrice(double nonBusiClassPrice) {
		NonBusiClassPrice = nonBusiClassPrice;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
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