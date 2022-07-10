package com.andpod.service;

import com.andpod.client.BooksClient;
import com.andpod.model.Book;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Singleton
public class BookService {

    private static Logger LOG = LoggerFactory.getLogger(BookService.class);

    private final BooksClient client;

    public BookService(BooksClient client) {
        this.client = client;
    }

    public List<Book> listAllBooks() {
        LOG.debug("Book Service -> List all books");
        return client.getAllBooks();
    }

    public void createBook(Book book) {
        LOG.debug("Book Service -> Create book");
        client.addBook(book);
    }
}
