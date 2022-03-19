package com.flightapp.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class BookingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pnr;

	@Column(nullable = false)
	private int userID;

	@Column(nullable = false)
	private double totalAmount;

	@Column(nullable = false)
	private int flightID;

	@Column(nullable = false)
	private String fromPlace;

	@Column(nullable = false)
	private String toPlace;

	@Column(nullable = false)
	private LocalDateTime fromTime;

	@Column(nullable = false)
	private LocalDateTime toTime;

	@JsonInclude
	@Transient
	private List<Passenger> passengers;
	
	@Column(nullable = false)
	private String status="";

	public int getPnr() {
		return pnr;
	}

	public void setPnr(int pnr) {
		this.pnr = pnr;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totAmt) {
		this.totalAmount = totAmt;
	}

	public int getFlightID() {
		return flightID;
	}

	public void setFlightID(int flightid) {
		this.flightID = flightid;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
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

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
