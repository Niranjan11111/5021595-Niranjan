package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT new com.example.employeemanagementsystem.repository.DepartmentProjectionImpl(d.id, d.name) " +
           "FROM Department d")
    List<DepartmentProjectionImpl> findAllDepartmentProjections();
}
