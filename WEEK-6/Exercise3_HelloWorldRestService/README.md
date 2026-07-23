# Exercise 3 — Hello World RESTful Web Service

## What this covers
- `HelloController.java` — a REST controller with `GET /hello`
- Returns the plain text `Hello World!!`
- Start/end logging included in `sayHello()`

## How to run
```bash
mvn clean package
mvn spring-boot:run
```

## Test it
```bash
curl http://localhost:8090/hello
# Hello World!!
```

Or open http://localhost:8090/hello directly in Chrome, or call it from
Postman. Check the Network tab (Chrome DevTools) / Headers tab (Postman)
to inspect the HTTP response headers.
