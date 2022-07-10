package com.andpod.controller;

import com.andpod.client.CatalogueClient;
import com.andpod.client.BookClient;
import com.andpod.model.Book;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

@Controller("/books")
public class BookController {

    public BookController(CatalogueClient catalogueClient, BookClient bookClient) {
        this.catalogueClient = catalogueClient;
        this.bookClient = bookClient;
    }

    private final CatalogueClient catalogueClient;
    private final BookClient bookClient;

    @Get
    public Publisher<Book> getBooks() {
        return Flux.from(catalogueClient.findAll(null))
                .flatMap(Flux::fromIterable);
    }

    @Post(consumes = MediaType.APPLICATION_JSON)
    public void createBook(@Body Book book) {
        bookClient.createBook(book);
    }
}
