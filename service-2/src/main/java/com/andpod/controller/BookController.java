package com.andpod.controller;

import com.andpod.client.CatalogueClient;
import com.andpod.model.Book;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

@Controller("/books")
public class BookController {

    public BookController(CatalogueClient catalogueClient) {
        this.catalogueClient = catalogueClient;
    }

    private final CatalogueClient catalogueClient;

    @Get
    public Publisher<Book> getBooks() {
        return Flux.from(catalogueClient.findAll(null))
                .flatMap(Flux::fromIterable);
    }
}
