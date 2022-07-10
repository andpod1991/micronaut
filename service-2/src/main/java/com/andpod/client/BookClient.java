package com.andpod.client;


import com.andpod.model.Book;
import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;

@RabbitClient("micronaut")
public interface BookClient {

    @Binding("books.creation")
    void createBook(Book book);
}
