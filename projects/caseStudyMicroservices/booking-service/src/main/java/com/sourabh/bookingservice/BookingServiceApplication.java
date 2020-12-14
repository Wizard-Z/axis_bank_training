package com.sourabh.bookingservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class BookingServiceApplication {
	static Logger logger = LoggerFactory.getLogger(BookingServiceApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(BookingServiceApplication.class, args);
		logger.info("[---------<<<<< Booking-Service >>>>>--------]");
	}

}
