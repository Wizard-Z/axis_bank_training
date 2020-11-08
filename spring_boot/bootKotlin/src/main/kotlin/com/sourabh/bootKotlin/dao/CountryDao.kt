package com.sourabh.bootKotlin.dao

import com.sourabh.bootKotlin.model.Country
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CountryDao : MongoRepository<Country?, Int?> {
    /*@get:Query("{language:'English'}")
    val englishCountries: MutableList<Country?>*/
    @Query("{name:1,capital:1}")
    fun findByname(name: String?): Country?
    fun findBylanguage(lang:String?): MutableList<Country?>?

    @Query("{population:{\$lt:?0}}")
    fun populationLessThan(value: Int?): MutableList<Country?>
}
