package com.flightapp.constants;

public enum AirportConstants {

	HYD("Hyderabad"), CHN("Chennai"), MUM("Mumbai"), BANG("Banglore");

	public final String description;

	AirportConstants(String desc) {
		this.description = desc;
	}

}
