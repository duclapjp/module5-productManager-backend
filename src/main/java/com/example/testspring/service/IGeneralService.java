package com.example.testspring.service;

import com.example.testspring.model.Product;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id) throws ChangeSetPersister.NotFoundException;

    Product save(T t);

    void remove(Long id);
}
