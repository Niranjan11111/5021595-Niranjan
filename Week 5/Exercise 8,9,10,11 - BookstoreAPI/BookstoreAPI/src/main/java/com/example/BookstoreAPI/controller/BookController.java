package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.assembler.BookModelAssembler;
import com.example.BookstoreAPI.exception.ResourceNotFoundException;
import com.example.BookstoreAPI.model.Book;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.mapper.BookMapper;
import com.example.BookstoreAPI.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookModelAssembler bookModelAssembler;

    @GetMapping
    public CollectionModel<EntityModel<Book>> getAllBooks() {
        List<EntityModel<Book>> books = bookRepository.findAll().stream()
                .map(bookModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(books,
                linkTo(methodOn(BookController.class).getAllBooks()).withSelfRel());
    }

    private List<Book> boo ks; // Assume this is populated

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> bookDTOs = books.stream()
                .map(bookMapper::bookToBookDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(bookDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")  
    public ResponseEntity<BookDTO> getBookById1(@PathVariable Long id) {
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
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
    
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    }
    
    @PutMapping("/books/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO bookDTO) {
        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID " + id));

        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPrice(bookDTO.getPrice());
        book.setIsbn(bookDTO.getIsbn());

        book = bookRepository.save(book);
        return new ResponseEntity<>(bookMapper.bookToBookDTO(book), HttpStatus.OK);
    }
    
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID " + id));

        bookRepository.delete(book);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}