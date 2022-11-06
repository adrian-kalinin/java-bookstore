package com.example.Bookstore.repositorytest;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.repository.BookRepository;
import com.example.Bookstore.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void createBook() {
        Book book = new Book("Title", "Author", 2022, "000-00-00000-00-0", 9.99, null);
        bookRepository.save(book);

        List<Book> foundBooks = bookRepository.findAll();
        assertThat(foundBooks).hasSize(1);
    }

    @Test
    void deleteBook() {
        Book book = new Book("Title", "Author", 2022, "000-00-00000-00-0", 9.99, null);
        bookRepository.save(book);
        bookRepository.delete(book);

        List<Book> foundBooks = bookRepository.findAll();
        assertThat(foundBooks).hasSize(0);
    }

    @Test
    void findBookByTitle() {
        Book book = new Book("Title", "Author", 2022, "000-00-00000-00-0", 9.99, null);
        bookRepository.save(book);

        List<Book> foundBooks = bookRepository.findByTitle("Title");
        assertThat(foundBooks.get(0)).isEqualTo(book);
    }

    @Test
    void findBookByCategoryId() {
        Category category = new Category("Category");
        categoryRepository.save(category);

        Book book = new Book("Title", "Author", 2022, "000-00-00000-00-0", 9.99, category);
        bookRepository.save(book);

        List<Book> foundBooks = bookRepository.findByCategoryId(category.getId());
        assertThat(foundBooks.get(0)).isEqualTo(book);
    }

}
