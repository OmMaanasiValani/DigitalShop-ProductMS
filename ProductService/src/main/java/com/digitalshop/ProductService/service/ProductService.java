package com.digitalshop.ProductService.service;

import com.digitalshop.ProductService.model.ProductRequest;
import com.digitalshop.ProductService.model.ProductResponse;

public interface ProductService {
    Long addProduct(ProductRequest product);

    ProductResponse getProduct(long id);

    void reduceQuantity(long id, long quantity);
}
