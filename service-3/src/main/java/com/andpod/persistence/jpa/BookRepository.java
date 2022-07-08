package com.andpod.persistence.jpa;

import com.andpod.persistence.entities.BookEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {

    @Override
    List<BookEntity> findAll();
}
