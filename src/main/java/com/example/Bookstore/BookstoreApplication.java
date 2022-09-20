package com.example.Bookstore;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {
    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner bookDemo(CategoryRepository categoryRepository, BookRepository bookRepository) {
        return (args) -> {
            log.info("Creating and saving a few demo books.");

            Category firstCategory = new Category("Self-help");
            Category secondCategory = new Category("Novel");

            categoryRepository.save(firstCategory);
            categoryRepository.save(secondCategory);

            Book firstBook = new Book("12 Rules for Life", "Jordan Peterson", 2018, "978-34-42315-53-6", 19.99, firstCategory);
            Book secondBook = new Book("Atlas Shrugged", "Ayn Rand", 1957, "978-04-51132-15-4", 9.99, secondCategory);

            bookRepository.save(firstBook);
            bookRepository.save(secondBook);
        };
    }

}
