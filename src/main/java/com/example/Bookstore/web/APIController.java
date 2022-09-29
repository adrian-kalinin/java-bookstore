package com.example.Bookstore.web;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class APIController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/_/books")
    public List<Book> listBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @GetMapping("/_/book/{id}")
    public Optional<Book> getBookById(@PathVariable(name = "id") Long bookId) {
        return bookRepository.findById(bookId);
    }

}
