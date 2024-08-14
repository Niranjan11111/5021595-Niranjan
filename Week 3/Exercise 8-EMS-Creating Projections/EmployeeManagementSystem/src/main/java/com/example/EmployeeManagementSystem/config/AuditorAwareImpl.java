package com.example.EmployeeManagementSystem.config;

import org.springframework.data.domain.AuditorAware;
import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Replace with actual user retrieval logic, e.g., from security context
        return Optional.of("system"); // Default user for demonstration purposes
    }
}
