# Exercise 5 — REST - Get Country Based on Country Code

## What this covers
- `country.xml` expanded to a full list (India, US, Japan, Germany) plus a
  `countryList` bean
- `CountryDao.java` — loads the country list from `country.xml` on startup
- `CountryService.java` — `getCountry(code)`, case-insensitive lookup,
  throws `CountryNotFoundException` if not found
- `CountryNotFoundException.java` — annotated with
  `@ResponseStatus(NOT_FOUND, reason = "Country not found")`
- `CountryController.java` — adds `GET /countries` (all) and
  `GET /countries/{code}` (case-insensitive single lookup)

## How to run
```bash
mvn clean package
mvn spring-boot:run
```

## Test it
```bash
curl http://localhost:8090/countries
# [{"code":"IN","name":"India"},{"code":"US","name":"United States"},{"code":"JP","name":"Japan"},{"code":"DE","name":"Germany"}]

curl http://localhost:8090/countries/in
# {"code":"IN","name":"India"}

curl -i http://localhost:8090/countries/az
# HTTP/1.1 404
# {"status":404,"error":"Not Found","message":"Country not found", ...}
```
