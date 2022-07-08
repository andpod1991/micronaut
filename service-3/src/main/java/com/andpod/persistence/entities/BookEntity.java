package com.andpod.persistence.entities;

import io.micronaut.core.annotation.Introspected;

import javax.persistence.*;

@Entity(name = "book")
@Introspected
@Table(name = "books", schema = "mn")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String isbn;
    private String name;
    private String author;

    public Integer getId() {
        return id;
    }

    public BookEntity(){}

    public BookEntity( String isbn, String name, String author) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
