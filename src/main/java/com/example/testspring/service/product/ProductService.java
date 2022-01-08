package com.example.testspring.service.product;

import com.example.testspring.model.Product;
import com.example.testspring.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) throws ChangeSetPersister.NotFoundException {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findProductByCode(String code) {
        return productRepository.findProductByCode(code);
    }

    @Override
    public List<String> getAllEmailToSend() {
        return productRepository.getAllEmailToSend();
    }
}
