# Exercise 4 — REST - Country Web Service

## What this covers
- `CountryController.java` — a REST controller with `GET /country`
- Loads the `indiaCountry` bean from `country.xml` (Spring XML config, see
  Exercise 2) and returns it — Spring automatically converts the `Country`
  bean into JSON.

## How to run
```bash
mvn clean package
mvn spring-boot:run
```

## Test it
```bash
curl http://localhost:8090/country
```

Expected response:
```json
{"code":"IN","name":"India"}
```

Check the Network tab (Chrome DevTools) or the Headers tab (Postman) to see
the `Content-Type: application/json` response header, and note how the
`Country` bean returned from the controller method is automatically
serialized to JSON.
