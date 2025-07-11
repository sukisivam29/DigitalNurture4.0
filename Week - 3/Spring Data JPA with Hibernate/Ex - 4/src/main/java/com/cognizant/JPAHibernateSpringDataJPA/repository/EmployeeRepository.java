package com.cognizant.JPAHibernateSpringDataJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.JPAHibernateSpringDataJPA.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
