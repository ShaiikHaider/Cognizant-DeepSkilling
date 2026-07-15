package com.example.comparison.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Raw Hibernate approach to persisting an Employee - manual Session,
 * Transaction, and exception handling. This is the boilerplate that
 * Spring Data JPA (see EmployeeRepository / EmployeeService) removes.
 */
public class HibernateAddEmployeeExample {

    private SessionFactory factory;

    /* Method to CREATE an employee in the database */
    public Integer addEmployee(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;

        try {
            tx = session.beginTransaction();
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return employeeID;
    }
}
