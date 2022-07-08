package com.andpod.controller;

import com.andpod.model.Book;
import com.andpod.service.BookService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller("/books")
public class BookController {

    private static Logger LOG = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    @Inject
    public BookController(BookService personService) {
        this.bookService = personService;
    }

    @Get
    public HttpResponse getBooks() {
        List<Book> allBooks = bookService.listAllBooks();

        if (allBooks.size() > 0) {
            return HttpResponse.ok(allBooks);
        }

        else {
            return HttpResponse.notFound();
        }
    }
}
