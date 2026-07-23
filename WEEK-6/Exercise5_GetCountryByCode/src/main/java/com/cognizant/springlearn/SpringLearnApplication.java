package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.model.Country;

/**
 * Exercise 2: Spring Core - Load Country from Spring Configuration XML
 */
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.debug("Start main()");
        SpringApplication.run(SpringLearnApplication.class, args);
        displayCountry();
        LOGGER.debug("End main()");
    }

    /**
     * Loads the "indiaCountry" bean defined in country.xml using
     * ClassPathXmlApplicationContext and displays it.
     */
    public static void displayCountry() {
        LOGGER.debug("Start displayCountry()");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("indiaCountry", Country.class);

        LOGGER.info("Loaded country from Spring XML configuration: {}", country);
        System.out.println("Loaded country from Spring XML configuration: " + country);

        LOGGER.debug("End displayCountry()");
    }
}
