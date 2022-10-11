package com.example.Bookstore.controller;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class APIController {

    private final BookRepository bookRepository;
    
    @Autowired
    public APIController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/api/v1/books")
    public List<Book> listBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @GetMapping("/api/v1/{id}")
    public Optional<Book> getBookById(@PathVariable(name = "id") Long bookId) {
        return bookRepository.findById(bookId);
    }

}
