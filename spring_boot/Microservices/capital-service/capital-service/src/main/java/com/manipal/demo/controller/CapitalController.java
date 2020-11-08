package com.manipal.demo.controller;

import com.manipal.demo.model.Capital;
import com.manipal.demo.repository.CapitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CapitalController {
    @Autowired
    CapitalRepository capitalRepository;

    @Autowired
    Environment environment;

    @GetMapping("/home")
    public String home(){
        return "Hello Mortals!!!";
    }
    @GetMapping("/capital-service/capital/{capitalName}")
    public Capital getCapitalByName(@PathVariable String capitalName) {
        Capital capital = capitalRepository.findByname(capitalName);
        capital.setPort(environment.getProperty("server.port"));
        return capital;
    }

    @GetMapping("/capital-service/country-code/{countryCode}")
    public Capital getCapitalById(@PathVariable String countryCode) {
        Capital capital = capitalRepository.findById(countryCode).orElseThrow(null);
        capital.setPort(environment.getProperty("server.port"));
        return capital;
    }
    @GetMapping("/capital-service/all")
    public List<Capital> getAll(){
        return capitalRepository.findAll();
    }

    @PostMapping("/capital-service/add")
    public Capital addCapital(@RequestBody Capital capital){
        capitalRepository.save(capital);
        capital.setPort(environment.getProperty("server.port"));
        return capital;
    }



}
