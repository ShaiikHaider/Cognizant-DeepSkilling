package com.cognizant.springlearn.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Country;

@Repository
public class CountryDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryDao.class);

    @SuppressWarnings("unchecked")
    private static final List<Country> COUNTRY_LIST;

    static {
        LOGGER.debug("Loading country list from country.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        COUNTRY_LIST = (List<Country>) context.getBean("countryList", List.class);
        LOGGER.debug("Loaded {} countries from country.xml", COUNTRY_LIST.size());
    }

    public List<Country> getAllCountries() {
        LOGGER.debug("Start getAllCountries()");
        return COUNTRY_LIST;
    }
}
