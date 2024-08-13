package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(name = "Employee.findByEmail")
    Optional<Employee> findByEmail(String email);
}
