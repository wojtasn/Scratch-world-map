package com.example.demo.controller;

import com.example.demo.common.domain.CountryTO;
import com.example.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CountryRestController {

    private final CountryService countryService;

    @Autowired
    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public Set<CountryTO> getCountries() {
        return countryService.findAll();
    }

    @PostMapping("/countries")
    public void addCountry(@RequestBody CountryTO countryTO) {
        countryService.add(countryTO);
    }
}
