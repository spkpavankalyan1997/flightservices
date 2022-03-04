package com.flightapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airline {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int airLineId;
	
	@Column(nullable = false)
	private String airLineCode;
	
	@Column(nullable = false)
	private String airLineDesc;
	
	@Column(nullable = false)
	private double rating;
	
	@Column(nullable = false)
	private String status;

	public int getAirLineId() {
		return airLineId;
	}

	public void setAirLineId(int airLineId) {
		this.airLineId = airLineId;
	}

	public String getAirLineCode() {
		return airLineCode;
	}

	public void setAirLineCode(String airLineCode) {
		this.airLineCode = airLineCode;
	}

	public String getAirLineDesc() {
		return airLineDesc;
	}

	public void setAirLineDesc(String airLineDesc) {
		this.airLineDesc = airLineDesc;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
