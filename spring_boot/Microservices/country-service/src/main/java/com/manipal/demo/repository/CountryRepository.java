package com.manipal.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manipal.demo.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
