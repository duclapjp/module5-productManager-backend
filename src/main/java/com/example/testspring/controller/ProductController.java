package com.example.testspring.controller;

import com.example.testspring.model.Product;
import com.example.testspring.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
//    @GetMapping()
//    public ResponseEntity<Iterable<Product>> getAllProduct(){
//        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
//    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return new ResponseEntity<>(productService.findById(id).get(),HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<String> createProduct(@RequestBody Product product){
        productService.save(product);
        return new ResponseEntity<>("Success!",HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> editProduct(@RequestBody Product product, @PathVariable Long id){
        product.setId(id);
        productService.save(product);
        return new ResponseEntity<>("Success!",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.remove(id);
        return new ResponseEntity<>("Success!",HttpStatus.OK);
    }

    // phân trang
    @GetMapping
    public ResponseEntity<?> pageProduct(@PageableDefault Pageable pageable){
        Page<Product> productPage = productService.findAllProduct(pageable);
        if (productPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(productPage,HttpStatus.OK);
        }
    }
    @GetMapping("/search/{code}")
    public ResponseEntity<?> findProductByCode(@PathVariable String code){
        Iterable<Product> product = productService.findProductByCode(code);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
}
