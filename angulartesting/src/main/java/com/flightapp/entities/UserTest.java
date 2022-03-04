package com.flightapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class UserTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private int usrID;

	@Column(nullable = false)
	private String usrName;
	
	@JsonInclude
	@Column(nullable = false)
	private int usrAge;
	
	@Column(nullable = false)
	private String gender;
	
	public int getUsrID() {
		return usrID;
	}

	public void setUsrID(int usrID) {
		this.usrID = usrID;
	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public int getUsrAge() {
		return usrAge;
	}

	public void setUsrAge(int usrAge) {
		this.usrAge = usrAge;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
