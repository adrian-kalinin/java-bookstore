package com.example.Bookstore.web;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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
        return "bookList";
    }

    @GetMapping("/book/create")
    public String createBook(Model model) {
        model.addAttribute("book", new Book());
        return "bookForm";
    }

    @PostMapping("/book/save")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "bookForm";
        }

        repository.save(book);
        return "redirect:../booklist";
    }

    @GetMapping("/book/{id}/edit")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        Book book = repository.findById(bookId).orElse(null);

        if (book != null) {
            model.addAttribute("book", book);
            return "bookForm";
        }

        return "redirect:../../booklist";
    }

    @GetMapping("/book/{id}/delete")
    public String deleteBook(@PathVariable("id") Long bookId) {
        if (repository.existsById(bookId)) {
            repository.deleteById(bookId);
        }
        return "redirect:../../booklist";
    }

}
