package com.manipal.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manipal.demo.model.CountryCodes;

@Repository
public interface CountryCodesRepository extends JpaRepository<CountryCodes, Integer> {
	
	CountryCodes findByCountryName(String countryName);

}
