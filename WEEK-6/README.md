# Spring REST + JWT Hands-on Exercises

Six standalone Maven/Spring Boot projects, one per exercise. Each folder is
independently runnable and cumulative — i.e. Exercise N contains everything
from Exercise N-1 plus that exercise's new work, so you can `cd` into any
single folder and run just that stage.

| Folder | Exercise |
|---|---|
| `Exercise1_SpringWebProject` | Create a Spring Web Project using Maven |
| `Exercise2_LoadCountryFromXML` | Spring Core – Load Country from Spring Configuration XML |
| `Exercise3_HelloWorldRestService` | Hello World RESTful Web Service |
| `Exercise4_CountryWebService` | REST - Country Web Service |
| `Exercise5_GetCountryByCode` | REST - Get country based on country code |
| `Exercise6_JWTAuthentication` | Create authentication service that returns JWT |

Each folder has its own `README.md` with run + test instructions.

## Quick start (any exercise)
```bash
cd Exercise6_JWTAuthentication
mvn clean package
mvn spring-boot:run
```

## Note
Written and validated for structural/syntactic correctness, but not
`mvn`-compiled in the authoring sandbox (no Maven Central access there).
Run `mvn clean package` in each folder to compile and verify — add proxy
flags if your network requires them.
