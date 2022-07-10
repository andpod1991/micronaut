package com.andpod.service;

import com.andpod.model.Book;
import com.andpod.persistence.entities.BookEntity;
import com.andpod.persistence.jpa.BookRepository;
import io.micronaut.rabbitmq.annotation.Queue;
import io.micronaut.rabbitmq.annotation.RabbitListener;


import java.util.List;
import java.util.stream.Collectors;

@RabbitListener
public class BookCatalogueService {

    private final BookRepository bookRepository;

    public BookCatalogueService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Queue("catalogue")
    List<Book> listBooks() {

        List<BookEntity> bookEntities = bookRepository.findAll();

        List<Book> result = bookEntities.stream()
                .map(bookEntity -> new Book(bookEntity.getIsbn(), bookEntity.getAuthor(), bookEntity.getName()))
                .collect(Collectors.toList());

        return result;
    }
}
