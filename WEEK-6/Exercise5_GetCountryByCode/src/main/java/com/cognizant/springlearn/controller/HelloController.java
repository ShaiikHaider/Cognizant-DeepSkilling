package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exercise 3: Hello World RESTful Web Service
 * GET /hello -> "Hello World!!"
 */
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String sayHello() {
        LOGGER.debug("Start sayHello()");
        String result = "Hello World!!";
        LOGGER.debug("End sayHello()");
        return result;
    }
}
