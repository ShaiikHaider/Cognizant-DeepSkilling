package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Exercise 6: Create authentication service that returns JWT
 *
 * Request:  curl -s -u user:pwd http://localhost:8090/authenticate
 * Response: {"token":"<jwt-token>"}
 */
@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    private static final String SECRET_KEY = "secretkey";
    private static final long TOKEN_VALIDITY_MILLIS = 1200000; // 20 minutes

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.debug("Start authenticate()");
        LOGGER.debug("authHeader : {}", authHeader);

        String user = getUser(authHeader);
        String token = generateJwt(user);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        LOGGER.debug("End authenticate()");
        return map;
    }

    /**
     * Decodes the Basic auth header (Basic base64(username:password))
     * and returns the username.
     */
    private String getUser(String authHeader) {
        LOGGER.debug("Start getUser()");

        String encodedCredentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedCredentials = new String(decodedBytes);
        String user = decodedCredentials.substring(0, decodedCredentials.indexOf(':'));

        LOGGER.debug("user : {}", user);
        LOGGER.debug("End getUser()");
        return user;
    }

    /**
     * Generates a signed JWT for the given user, valid for 20 minutes.
     */
    private String generateJwt(String user) {
        LOGGER.debug("Start generateJwt() user={}", user);

        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY_MILLIS));
        builder.signWith(SignatureAlgorithm.HS256, SECRET_KEY);
        String token = builder.compact();

        LOGGER.debug("token : {}", token);
        LOGGER.debug("End generateJwt()");
        return token;
    }
}
