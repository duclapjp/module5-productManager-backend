package com.example.testspring.service.product;

import com.example.testspring.model.Product;
import com.example.testspring.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService extends IGeneralService<Product> {
    Page<Product> findAllProduct(Pageable pageable);
    Iterable<Product> findProductByCode(String code);
}
