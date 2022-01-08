package com.example.testspring.controller;

import com.example.testspring.model.Product;
import com.example.testspring.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class WebsocketController {
    @Autowired
    private IProductService productService;

    @MessageMapping("/products")
    @SendTo("/topic/product")
    public Product createNewProduct(Product product){
        return productService.save(product);
    }
}
