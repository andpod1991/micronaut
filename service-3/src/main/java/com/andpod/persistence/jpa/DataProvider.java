package com.andpod.persistence.jpa;

import com.andpod.model.Book;
import com.andpod.persistence.entities.BookEntity;
import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Singleton
@Requires(notEnv = Environment.TEST)
public class DataProvider {

    private static final Logger LOG = LoggerFactory.getLogger(DataProvider.class);

    private final BookRepository bookRepository;

    public DataProvider(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener
    public void init(StartupEvent event) {

        LOG.info("Adding test data as empty database was found!!!");

        if (bookRepository.count() == 0) {

            List<BookEntity> listOfBooks = List.of(
                    new BookEntity("1232345698", "Amintiri din copilarie", "Ion Creanga"),
                    new BookEntity("1236566556", "Ion", "Liviu Rebreanu"),
                    new BookEntity("1232345345", "Noi suntem romani", "Radu Paraschivescu")
            );

            bookRepository.saveAll(listOfBooks);

        }
    }
}
