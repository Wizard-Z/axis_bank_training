package com.manipal.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class CountryCodes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String countryCode;
	private String countryName;
	
	public CountryCodes() {}
	
	

	public CountryCodes(int id, String countryCode, String countryName) {
		super();
		this.id = id;
		this.countryCode = countryCode;
		this.countryName = countryName;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}



	@Override
	public String toString() {
		return "CountryCodes [id=" + id + ", countryCode=" + countryCode + ", countryName=" + countryName + "]";
	}
	
	
	

}
