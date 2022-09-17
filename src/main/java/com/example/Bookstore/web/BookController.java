package com.example.Bookstore.web;

import com.example.Bookstore.domain.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping("/")
    public String index() {
        return "redirect:/booklist";
    }

    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @GetMapping("/book/{id}/delete")
    public String deleteBook(@PathVariable("id") Long bookId) {
        if (repository.existsById(bookId)) {
            repository.deleteById(bookId);
        }
        return "redirect:../../booklist";
    }

}
