package com.manipal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.demo.model.Capital;
import com.manipal.demo.model.Country;
import com.manipal.demo.model.CountryCodes;
import com.manipal.demo.proxy.CapitalServiceProxy;
import com.manipal.demo.repository.CountryCodesRepository;
import com.manipal.demo.repository.CountryRepository;

@RestController
public class CountryController {
	@Autowired
	private CapitalServiceProxy proxy;
	
	@Autowired
	CountryRepository repo;
	
	@Autowired
	CountryCodesRepository countryCodesRepo;
	
	@GetMapping("/home")
	public String home() {
		return "Country-service";
	}
	@PostMapping("country-service/add/codes")
	public CountryCodes addCodes(@RequestBody CountryCodes countryCodes) {
		return countryCodesRepo.save(countryCodes);
	}
	
	@GetMapping("/country-service/country/{countryName}")
	public Country getCountryDetails(@PathVariable String countryName) {
		CountryCodes countryCodes= countryCodesRepo.findByCountryName(countryName);
		System.out.println("\n\n======\n"+countryCodes);
		Capital capital = proxy.retriveCapital(countryCodes.getCountryCode());
		Country country = new Country();
		country.setCountryName(countryName);
		country.setCountryCode(countryCodes.getCountryCode());
		country.setCapital(capital);
		System.out.println("\n\n\n------\n"+country+"-----\n\n\n\n");
		//repo.save(country);
		return country;			
		
	}
	@PostMapping("/country-service/country/{countryName}")
	public Country putCountryDetails(@PathVariable String countryName) {
		CountryCodes countryCodes= countryCodesRepo.findByCountryName(countryName);
		System.out.println("\n\n======\n"+countryCodes);
		Capital capital = proxy.retriveCapital(countryCodes.getCountryCode());
		Country country = new Country();
		country.setCountryName(countryName);
		country.setCountryCode(countryCodes.getCountryCode());
		country.setCapital(capital);
		System.out.println("\n\n\n------\n"+country+"-----\n\n\n\n");
		repo.save(country);
		return country;		
		
	}
	
	@GetMapping("/country-service/show-all-codes")
	public List<CountryCodes> getAll(){
		return countryCodesRepo.findAll();
	}
	@GetMapping("/country-service/all")
	public List<Country> getAllCountries(){
		return repo.findAll();
	}
	
	

}
