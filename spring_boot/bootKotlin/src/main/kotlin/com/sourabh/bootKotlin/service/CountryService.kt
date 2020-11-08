package com.sourabh.bootKotlin.service

import com.sourabh.bootKotlin.dao.CountryDao
import com.sourabh.bootKotlin.exception.CountryNotFoundException
import com.sourabh.bootKotlin.model.Country
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CountryService(@Autowired private var countryDao: CountryDao) {
    fun addOrUpdateCountry(country: Country): Country {
        return countryDao.save(country)
    }
    fun getAll(): MutableList<Country?> {
        return countryDao.findAll()
    }
    fun addBulk(countries: MutableList<Country>): MutableList<Country> {
        return countryDao.insert(countries)

    }

    fun getCountry(id: Int): Country?{
        return countryDao.findById(id).orElseThrow { CountryNotFoundException("No Country found for the id: $id") }

    }

    fun getCountryByName(name: String) :Country?{
        return countryDao.findByname(name) ?: throw(CountryNotFoundException("$name NOT available"))
    }

    fun getContriesLang(lang:String): MutableList<Country?>? {
        return countryDao.findBylanguage(lang) ?: throw(CountryNotFoundException("$lang Not spoken here!!"))
    }

    fun countryPopulationLessThan(value: Int): MutableList<Country?> {
        return countryDao.populationLessThan(value)

    }

    fun deleteCountry(id: Int) {
        countryDao.deleteById(id)
    }


}