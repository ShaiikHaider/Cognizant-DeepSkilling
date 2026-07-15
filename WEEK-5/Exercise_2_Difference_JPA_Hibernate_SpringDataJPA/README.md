# Exercise 2: Difference between JPA, Hibernate and Spring Data JPA

## Java Persistence API (JPA)

- A specification - JSR 338 - for persisting, reading, and managing
  data from Java objects.
- Defines *what* an ORM layer should do, not *how*.
- Contains no concrete implementation itself.

## Hibernate

- An ORM tool that **implements** the JPA specification.
- Handles the actual mapping between Java objects and database tables,
  session/transaction management, and SQL generation.

## Spring Data JPA

- Does not implement JPA itself - it sits **on top of** a JPA
  provider like Hibernate.
- Removes boilerplate code (manual `Session`/`Transaction` handling,
  try/catch/finally blocks) by generating repository implementations
  at runtime from an interface.
- Also manages transactions declaratively via `@Transactional`.

In short: **JPA is the spec, Hibernate is an implementation of that
spec, and Spring Data JPA is a convenience layer built on top of an
implementation like Hibernate.**

## Code comparison: adding an employee

**Hibernate** (`HibernateAddEmployeeExample.java`) - manual session and
transaction lifecycle:

```java
public Integer addEmployee(Employee employee) {
    Session session = factory.openSession();
    Transaction tx = null;
    Integer employeeID = null;
    try {
        tx = session.beginTransaction();
        employeeID = (Integer) session.save(employee);
        tx.commit();
    } catch (HibernateException e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        session.close();
    }
    return employeeID;
}
```

**Spring Data JPA** (`EmployeeRepository.java` + `EmployeeService.java`)
- no session handling, no manual transaction control:

```java
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
```

```java
@Autowired
private EmployeeRepository employeeRepository;

@Transactional
public void addEmployee(Employee employee) {
    employeeRepository.save(employee);
}
```

Same outcome - an employee row is inserted - but the Spring Data JPA
version has no session lifecycle code, no manual rollback logic, and
no boilerplate exception handling. `save()` comes for free from
`JpaRepository`, and `@Transactional` handles the transaction
boundary declaratively.

## Files in this folder

| File | Package | Purpose |
|---|---|---|
| `HibernateAddEmployeeExample.java` | `com.example.comparison.hibernate` | Raw Hibernate Session/Transaction approach |
| `Employee.java` | `com.example.comparison.hibernate` | Plain POJO used by the Hibernate example |
| `EmployeeRepository.java` | `com.example.comparison.springdatajpa` | Spring Data JPA repository interface |
| `EmployeeService.java` | `com.example.comparison.springdatajpa` | Service using the repository with `@Transactional` |
| `Employee_JPA.java` | `com.example.comparison.springdatajpa` | `@Entity`-annotated Employee for the Spring Data JPA side |

## Reference links

- https://dzone.com/articles/what-is-the-difference-between-hibernate-and-sprin-1
- https://www.javaworld.com/article/3379043/what-is-jpa-introduction-to-the-java-persistence-api.html
