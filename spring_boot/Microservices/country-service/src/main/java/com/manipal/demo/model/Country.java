package com.manipal.demo.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String countryName;
	private String countryCode;
	@Embedded
	private Capital capital;
	
	public Country () {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Capital getCapital() {
		return capital;
	}

	public void setCapital(Capital capital) {
		this.capital = capital;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", countryName=" + countryName + ", countryCode=" + countryCode + ", capital="
				+ capital + "]";
	}
	
	
	
	
	
}