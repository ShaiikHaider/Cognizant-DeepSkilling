package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    /**
     * Exercise 4: REST - Country Web Service
     * GET /country -> returns India country details
     */
    @RequestMapping("/country")
    public Country getCountryIndia() {
        LOGGER.debug("Start getCountryIndia()");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("indiaCountry", Country.class);

        LOGGER.debug("End getCountryIndia() : {}", country);
        return country;
    }

    /**
     * REST - Get all countries
     */
    @GetMapping("/countries")
    public java.util.List<Country> getAllCountries() {
        LOGGER.debug("Start getAllCountries()");
        java.util.List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("End getAllCountries() : {} countries", countries.size());
        return countries;
    }

    /**
     * Exercise 5: REST - Get country based on country code (case insensitive)
     * GET /countries/{code} -> returns 404 "Country not found" if code doesn't exist
     */
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.debug("Start getCountry() code={}", code);
        Country country = countryService.getCountry(code);
        LOGGER.debug("End getCountry() : {}", country);
        return country;
    }
}
