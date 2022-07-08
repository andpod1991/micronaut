package com.andpod.client;

import com.andpod.model.Book;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Retryable;

import java.util.List;

@Client("http://localhost:8090")
public interface BooksClient {

    @Post("/books")
    Book addBook(@Body Book book);

    @Get("/books")
    @Retryable(attempts = "3", delay = "2s")
    List<Book> getAllBooks();
}
