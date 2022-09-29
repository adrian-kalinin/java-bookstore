package com.example.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByTitle(@Param("title") String title);
    List<Book> findByCategoryId(@Param("category") Long categoryId);

}
