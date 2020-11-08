package com.manipal.demo.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.manipal.demo.model.Capital;

@FeignClient(name="capital-service")//,url="localhost:8000")
@RibbonClient(name="capital-service")
public interface CapitalServiceProxy {
	@GetMapping("/capital-service/country-code/{countryCode}")
	public Capital retriveCapital(@PathVariable String countryCode);
	

}
