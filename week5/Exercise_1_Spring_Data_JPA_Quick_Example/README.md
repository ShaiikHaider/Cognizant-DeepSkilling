# Exercise 1: Spring Data JPA - Quick Example

## What this is

A minimal Spring Boot + Spring Data JPA project that reads a `country`
table from MySQL through a repository, service, and entity - the
smallest possible end-to-end Spring Data JPA setup.

## Database setup

```sql
mysql -u root -p
mysql> create schema ormlearn;
mysql> use ormlearn;

create table country(co_code varchar(2) primary key, co_name varchar(50));

insert into country values ('IN', 'India');
insert into country values ('US', 'United States of America');
```

## Project layout

```
orm-learn/
  pom.xml
  src/main/resources/application.properties
  src/main/java/com/cognizant/ormlearn/
    OrmLearnApplication.java       <- main class, runs a test query on startup
    model/Country.java             <- @Entity mapped to the country table
    repository/CountryRepository.java  <- extends JpaRepository, no code needed
    service/CountryService.java    <- @Transactional wrapper around the repository
```

## Key concepts (from the walkthrough)

- `@Entity` marks a class as a JPA-managed entity.
- `@Table` maps it to a specific database table.
- `@Id` marks the primary key field.
- `@Column` maps a field to a specific column.
- `CountryRepository extends JpaRepository<Country, String>` gives you
  `findAll()`, `findById()`, `save()`, `deleteById()`, etc. for free -
  no implementation needed.
- `@Transactional` on the service method ensures the read happens
  within a transaction.

## Running it

1. Update `spring.datasource.username` / `password` in
   `application.properties` to match your local MySQL setup.
2. `mvn clean package`
3. `mvn spring-boot:run` (or run `OrmLearnApplication` directly)
4. Check the console logs - you should see the SQL query execute and
   the two country records printed via `LOGGER.debug`.

**Note:** this project targets MySQL, per the original walkthrough. If
you don't have MySQL running locally, swap the datasource dependency
and properties for H2 (`jdbc:h2:mem:testdb`) to run it without any
external database - the entity/repository/service code doesn't change.
