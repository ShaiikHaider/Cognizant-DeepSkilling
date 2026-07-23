# Exercise 2 — Spring Core: Load Country from Spring Configuration XML

## What this covers
- `Country.java` — a simple model bean (code, name)
- `country.xml` — Spring XML configuration defining an `indiaCountry` bean
- `SpringLearnApplication.displayCountry()` — loads `country.xml` via
  `ClassPathXmlApplicationContext`, retrieves the bean with `getBean()`,
  and prints it

## How to run
```bash
mvn clean package
mvn spring-boot:run
```

Look at the console output on startup — you'll see:
```
Loaded country from Spring XML configuration: Country [code=IN, name=India]
```

This demonstrates defining a bean in Spring XML config and retrieving it
via `ApplicationContext.getBean()`, avoiding creating the same object
repeatedly in code — the same pattern used for the `SimpleDateFormat`
example in the reference material, applied here to `Country`.
