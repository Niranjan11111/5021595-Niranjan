package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Derived query method to find employees by name
    List<Employee> findByName(String name);

    // Derived query method to find employees by department
    List<Employee> findByDepartmentName(String departmentName);
}
