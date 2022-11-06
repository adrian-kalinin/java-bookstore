package com.example.Bookstore;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.User;
import com.example.Bookstore.repository.BookRepository;
import com.example.Bookstore.repository.CategoryRepository;
import com.example.Bookstore.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@SpringBootApplication
public class BookstoreApplication {
    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    @Profile("!test")
    public CommandLineRunner bookDemo(CategoryRepository categoryRepository, BookRepository bookRepository, UserRepository userRepository) {
        return (args) -> {
            log.info("Creating and saving demo data.");

            // Create categories
            categoryRepository.saveAll(Arrays.asList(
                    new Category("Self-help"),
                    new Category("Novel"),
                    new Category("Fantasy"),
                    new Category("Mystery"),
                    new Category("Romance")
            ));

            // Create books
            bookRepository.saveAll(Arrays.asList(
                    new Book("12 Rules for Life", "Jordan Peterson", 2018, "978-34-42315-53-6", 19.99, categoryRepository.findById(1L).orElse(null)),
                    new Book("Atlas Shrugged", "Ayn Rand", 1957, "978-04-51132-15-4", 9.99, categoryRepository.findById(2L).orElse(null))
            ));

            // Create users
            userRepository.saveAll(Arrays.asList(
                    new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@example.com", "USER"),
                    new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@example.com", "ADMIN")
            ));
        };
    }

}
