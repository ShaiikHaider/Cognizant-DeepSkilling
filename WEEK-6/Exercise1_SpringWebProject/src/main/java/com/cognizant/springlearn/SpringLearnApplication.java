package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Exercise 1: Create a Spring Web Project using Maven
 *
 * Group: com.cognizant | Artifact: spring-learn
 * Built with Spring Boot DevTools + Spring Web starters.
 */
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.debug("Start main()");
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.debug("End main()");
    }
}
