package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query(name = "Department.findByName")
    Optional<Department> findByName(String name);
}
