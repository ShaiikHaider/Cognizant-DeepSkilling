# Exercise 1 — Create a Spring Web Project using Maven

## What this covers
- Spring Initializr-style project (Group: `com.cognizant`, Artifact: `spring-learn`)
- Spring Boot DevTools + Spring Web dependencies
- `SpringLearnApplication.java` main class with start/end logging

## How to run
```bash
mvn clean package
mvn spring-boot:run
```

Check the console log for the "Start main()" / "End main()" debug lines,
confirming the app booted and logging is working.

## Walkthrough points (as per hands-on)
- `src/main/java` — application code
- `src/main/resources` — application configuration (`application.properties`)
- `SpringLearnApplication.java` — entry point, `@SpringBootApplication`,
  `SpringApplication.run()`
- `pom.xml` — Maven dependency configuration (open "Dependency Hierarchy" in
  Eclipse to see the full dependency tree)
