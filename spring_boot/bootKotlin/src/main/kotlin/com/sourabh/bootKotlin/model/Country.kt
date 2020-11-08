package com.sourabh.bootKotlin.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "countryK")
class Country(@Id  var countryId: Int,
                   var name: String,
                   var capital: String,
                   var population: Int,
                   var language: String) {

}