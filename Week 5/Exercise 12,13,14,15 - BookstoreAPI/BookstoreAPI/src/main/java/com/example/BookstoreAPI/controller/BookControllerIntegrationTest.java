package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.IntegrationTestBase;
import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@AutoConfigureMockMvc
public class BookControllerIntegrationTest extends IntegrationTestBase {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void setup() {
        bookRepository.deleteAll();
        bookRepository.save(new Book(null, 0, "Sample Book", "Sample Author", 29.99, "1234567890"));
    }

    @Test
    public void testGetAllBooks() throws Exception {
        mockMvc.perform(get("/books")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Sample Book"))
                .andDo(print());
    }

    @Test
    public void testAddBook() throws Exception {
        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"New Book\",\"author\":\"New Author\",\"price\":19.99,\"isbn\":\"0987654321\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("New Book"))
                .andDo(print());
    }

}
