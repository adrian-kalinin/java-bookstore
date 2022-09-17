package com.example.Bookstore;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

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
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("Creating and saving a few demo books.");

			Book firstBook = new Book("12 Rules for Life", "Jordan Peterson", 2018, "978-34-42315-53-6", 19.99);
			Book secondBook = new Book("Atlas Shrugged", "Ayn Rand", 1957, "978-04-51132-15-4", 9.99);

			repository.save(firstBook);
			repository.save(secondBook);
		};
	}

}
