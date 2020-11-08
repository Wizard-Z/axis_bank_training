package com.sourabh.bootKotlin.controller

import com.sourabh.bootKotlin.model.Country
import com.sourabh.bootKotlin.service.CountryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CountryController(@Autowired private val countryService: CountryService) {

    @GetMapping("/home")
    fun home():String{
        return "Hello Mortals!!"
    }
    @PostMapping("/countries")
    fun addOrUpdate(@RequestBody country: Country):Country{
        return countryService.addOrUpdateCountry(country)
    }
    @PostMapping("/countries/bulk")
    fun addBulk(@RequestBody countries: MutableList<Country>): MutableList<Country> {
        return countryService.addBulk(countries)
    }
    @GetMapping("/countries")
    fun getAll(): MutableList<Country?> {
        return countryService.getAll()
    }
    @GetMapping("/countries/{id}")
    fun getCountry(@PathVariable id: Int): Country? {/*
        val country = countryService.getCountry(id)
        val linkBuilder= linkTo(methodOn(CountryController.class).getAll())
        val linkBuilder1: WebMvcLinkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn().retrieveTodo(id))
        val entityModel: EntityModel<*> = EntityModel.of<Any>(toDo)
        entityModel.add(linkBuilder.withRel("all-todos"))
        entityModel.add(linkBuilder1.withSelfRel())*/
        return countryService.getCountry(id)
    }
    @GetMapping("/countries/name/{name}")
    fun getCountryByName(@PathVariable name: String):Country?{
        return countryService.getCountryByName(name)
    }
    @GetMapping("/countries/lang/{lang}")
    fun getEnglishCountries(@PathVariable lang: String): MutableList<Country?>? {
        return countryService.getContriesLang(lang)
    }
    @GetMapping("/countries/lt/{value}")
    fun countryPopulationLessThan(@PathVariable value: Int):MutableList<Country?>{
        return countryService.countryPopulationLessThan(value)
    }

    @PutMapping("/countries/{id}")
    fun updateCountry(@PathVariable id: Int, @RequestBody countryDetails: Country): ResponseEntity<Any?> {
        val countryOld = countryService.getCountry(id)
        countryOld!!.countryId=countryDetails.countryId
        countryOld.name =countryDetails.name
        countryOld.capital=countryDetails.capital
        countryOld.language=countryDetails.language
        countryOld.population=countryDetails.population
        val countryUpdated= countryService.addOrUpdateCountry(countryOld)
        val headers = HttpHeaders()
        headers.add("Response-from", "CountryController")
        return ResponseEntity<Any?>(countryUpdated, headers, HttpStatus.OK)
    }
    @DeleteMapping("/countries/{id}")
    fun deleteCountry(@PathVariable id: Int): String {
        val country = countryService.getCountry(id)
        countryService.deleteCountry(id)
        return "Deleted record for country id: ${country?.countryId} name: ${country?.name}"

    }

}