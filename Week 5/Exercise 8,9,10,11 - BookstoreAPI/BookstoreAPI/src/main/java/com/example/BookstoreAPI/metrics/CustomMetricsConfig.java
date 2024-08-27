package com.example.BookstoreAPI.metrics;

import com.example.BookstoreAPI.repository.BookRepository;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomMetricsConfig {

    @Autowired
    public CustomMetricsConfig(MeterRegistry meterRegistry, BookRepository bookRepository) {
        meterRegistry.gauge("bookstore.books.count", bookRepository.count());
    }
}
