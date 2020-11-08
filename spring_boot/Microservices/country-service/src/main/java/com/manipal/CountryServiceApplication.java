package com.manipal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class CountryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryServiceApplication.class, args);
		System.out.println("----<< COUNTRY-SERVICE >>----");
	}

}
