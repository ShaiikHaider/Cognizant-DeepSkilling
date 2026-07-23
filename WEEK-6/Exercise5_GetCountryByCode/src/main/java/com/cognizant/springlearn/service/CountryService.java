package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springlearn.dao.CountryDao;
import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    @Autowired
    private CountryDao countryDao;

    @Transactional
    public List<Country> getAllCountries() {
        LOGGER.debug("Start getAllCountries()");
        return countryDao.getAllCountries();
    }

    /**
     * Exercise 5: REST - Get country based on country code (case insensitive)
     * Throws CountryNotFoundException if the code does not exist.
     */
    public Country getCountry(String code) throws CountryNotFoundException {
        LOGGER.debug("Start getCountry() code={}", code);
        return countryDao.getAllCountries().stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException("Country not found"));
    }
}
