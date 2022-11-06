package com.example.Bookstore.repositorytest;

import com.example.Bookstore.model.Category;
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
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void createCategory() {
        Category category = new Category("Name");
        categoryRepository.save(category);

        List<Category> foundCategories = categoryRepository.findAll();
        assertThat(foundCategories).hasSize(1);
    }

    @Test
    void deleteCategory() {
        Category category = new Category("Name");
        categoryRepository.save(category);
        categoryRepository.delete(category);

        List<Category> foundCategories = categoryRepository.findAll();
        assertThat(foundCategories).hasSize(0);
    }

    @Test
    void findCategoryByName() {
        Category category = new Category("Name");
        categoryRepository.save(category);

        List<Category> foundCategories = categoryRepository.findByName("Name");
        assertThat(foundCategories.get(0)).isEqualTo(category);
    }

}
