package com.example.Bookstore.web;

import com.example.Bookstore.domain.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping("/booklist")
    public String bookstore(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

}
