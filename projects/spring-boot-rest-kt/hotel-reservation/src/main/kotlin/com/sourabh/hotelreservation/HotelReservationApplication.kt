package com.sourabh.hotelreservation

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import springfox.documentation.swagger2.annotations.EnableSwagger2
@Configuration
@SpringBootApplication
@EnableSwagger2
class HotelReservationApplication

fun main(args: Array<String>) {
	val logger: Logger = LoggerFactory.getLogger(HotelReservationApplication::class.java)
	runApplication<HotelReservationApplication>(*args)
	logger.info("[*---------<<<<< TOMCAT >>>>>--------*]")


}