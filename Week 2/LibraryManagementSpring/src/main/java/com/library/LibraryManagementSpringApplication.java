package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.library.repository")
@EntityScan(basePackages = "com.library.entity")
public class LibraryManagementSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementSpringApplication.class, args);
    }
}
