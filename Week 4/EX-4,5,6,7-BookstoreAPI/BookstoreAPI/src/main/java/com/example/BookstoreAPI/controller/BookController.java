package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.exception.ResourceNotFoundException;
import com.example.BookstoreAPI.model.Book;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.mapper.BookMapper;

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books; // Assume this is populated

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> bookDTOs = books.stream()
                .map(bookMapper::bookToBookDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(bookDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        Book book = books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Book with ID " + id + " not found"));

        BookDTO bookDTO = bookMapper.bookToBookDTO(book);
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
        Book book = bookMapper.bookDTOToBook(bookDTO);
        books.add(book);
        return new ResponseEntity<>(bookDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        Book book = books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Book with ID " + id + " not found"));

        book = bookMapper.bookDTOToBook(bookDTO);
        books.add(book);

        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Book book = books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Book with ID " + id + " not found"));

        books.remove(book);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}