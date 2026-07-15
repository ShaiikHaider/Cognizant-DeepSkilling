package com.example.comparison.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA approach - the entire "add employee" data-access layer
 * is this interface. save() is inherited from JpaRepository; no Session,
 * Transaction, or try/catch/finally boilerplate to write.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
