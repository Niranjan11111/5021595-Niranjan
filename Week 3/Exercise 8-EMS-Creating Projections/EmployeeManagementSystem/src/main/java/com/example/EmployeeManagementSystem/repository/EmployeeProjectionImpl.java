package com.example.EmployeeManagementSystem.repository;

public class EmployeeProjectionImpl {

    private Long id;
    private String name;
    private String email;
    private String departmentName;

    public EmployeeProjectionImpl(Long id, String name, String email, String departmentName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departmentName = departmentName;
    }

    // Getters and setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getDepartmentName() { return departmentName; }
}
