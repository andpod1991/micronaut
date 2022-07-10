package com.andpod.service;

import com.andpod.model.Book;
import com.andpod.persistence.entities.BookEntity;
import com.andpod.persistence.jpa.BookRepository;
import io.micronaut.rabbitmq.annotation.Queue;
import io.micronaut.rabbitmq.annotation.RabbitListener;


@RabbitListener
public class BookCreationService {

    private final BookRepository bookRepository;

    public BookCreationService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Queue("creation")
    void createBook(Book book) {

        BookEntity bookEntity = new BookEntity();
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setName(book.getName());
        bookRepository.save(bookEntity);
    }
}
