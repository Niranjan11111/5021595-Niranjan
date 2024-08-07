package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;

public class LibraryManagementApp {
    public static void main(String[] args) {
        // Load the Spring context from applicationContext.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Call the method to display books
        bookService.displayBooks();
    }
}
