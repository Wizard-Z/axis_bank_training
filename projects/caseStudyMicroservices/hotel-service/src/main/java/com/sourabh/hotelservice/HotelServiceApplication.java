package com.sourabh.hotelservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2
public class HotelServiceApplication {
	static Logger logger = LoggerFactory.getLogger(HotelServiceApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(HotelServiceApplication.class, args);
		logger.info("[---------<<<<< Hotel-Service >>>>>--------]");
	}

	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.sourabh"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails(){
		return new ApiInfo(
				"Rooms Service API",
				"For testing and demo purpose.",
				"1.0",
				"Open",
				new springfox.documentation.service.Contact("Sourabh Choubey","url.com","sf@df"),
				"API License",
				"https://opensource.com/",
				Collections.emptyList());

	}

}
