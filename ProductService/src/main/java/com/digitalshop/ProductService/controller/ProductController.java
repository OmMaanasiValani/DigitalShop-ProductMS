package com.digitalshop.ProductService.controller;

import com.digitalshop.ProductService.model.ProductRequest;
import com.digitalshop.ProductService.model.ProductResponse;
import com.digitalshop.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest product){

        Long productId = productService.addProduct(product);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable long id){

        ProductResponse product = productService.getProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
