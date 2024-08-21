package com.example.BookstoreAPI.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import com.example.BookstoreAPI.model.Book;

@RestController
@RequestMapping("/books")
public class BookController {

    // Initialize the books list as a class-level variable
    private List<Book> books = new ArrayList<>();

    @GetMapping
    public List<Book> getAllBooks() {
        return books; // This will return the list of books as a JSON response
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        books.add(book);
        return book; // The added book will be returned as a JSON response
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setPrice(updatedBook.getPrice());
                book.setIsbn(updatedBook.getIsbn());
                return book; // The updated book will be returned as a JSON response
            }
        }
        return null; // Handle this case more gracefully in a real application
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        books.removeIf(book -> book.getId().equals(id));
        return "Book with ID " + id + " deleted."; // A confirmation message
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return books.stream()
                    .filter(book -> book.getId().equals(id
