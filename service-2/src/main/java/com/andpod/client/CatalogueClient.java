package com.andpod.client;

import com.andpod.model.Book;
import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;
import io.micronaut.rabbitmq.annotation.RabbitProperty;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import java.util.List;

@RabbitClient("micronaut")
@RabbitProperty(name = "replyTo", value = "amq.rabbitmq.reply-to")
public interface CatalogueClient {

    @Binding("books.catalogue")
    Publisher<List<Book>> findAll(byte[] data);
}
