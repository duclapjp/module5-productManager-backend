package com.example.testspring.repository;

import com.example.testspring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface IProductRepository extends JpaRepository<Product, Long> {
    Product findProductByCode(String code);
    @Query(value = "SELECT email from product", nativeQuery = true)
    List<String> getAllEmailToSend();
}
