package com.example.Bookstore.domain;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 120)
    private String title;
    @Column(length = 40)
    private String author;
    @Column(name="release_year")
    private int year;
    @Column(length = 17)
    private String isbn;
    @Column(precision = 8, scale = 2)
    private double price;

    public Book() {}

    public Book(String title, String author, int year, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [id= " + id + ", title='" + title + "', author='" + author + "', year='" + this.year + "', isbn=" + isbn + ", price=" + price + "]";
    }

}
