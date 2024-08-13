package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create or Update Employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Read Employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Read All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Delete Employee by ID
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
