package com.flightapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int usrID;

	@Column(nullable = false)
	private String usrName;
	
	@Column(nullable = false)
	private String usrEmail;

	@Column(nullable = false)
	private String usrMobile;

	@Column(nullable = false)
	private String usrPassword;

	@JsonInclude
	@Column(nullable = false)
	private int usrAge;

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

	public String getUsrEmail() {
		return usrEmail;
	}

	public void setUsrEmail(String usrEmail) {
		this.usrEmail = usrEmail;
	}

	public String getUsrMobile() {
		return usrMobile;
	}

	public void setUsrMobile(String usrMobile) {
		this.usrMobile = usrMobile;
	}

	public String getUsrPassword() {
		return usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}

	public int getUsrAge() {
		return usrAge;
	}

	public void setUsrAge(int usrAge) {
		this.usrAge = usrAge;
	}

}
