package com.digitalshop.ProductService.service;

import com.digitalshop.ProductService.entity.ProductEntity;
import com.digitalshop.ProductService.exception.ProductNotFoundException;
import com.digitalshop.ProductService.model.ProductRequest;
import com.digitalshop.ProductService.model.ProductResponse;
import com.digitalshop.ProductService.repository.ProductRepo;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements  ProductService{
    @Autowired
    ProductRepo productRepo;
    @Override
    public Long addProduct(ProductRequest product) {
        log.info("Adding product..");
        ProductEntity productEntity = ProductEntity.builder()
                .product_name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
        productRepo.save(productEntity);
        log.info("Product added ..");
        return productEntity.getProductId();
    }

    @Override
    public ProductResponse getProduct(long id) {
        ProductEntity productEntity = productRepo.findById(id)
                .orElseThrow(()->new ProductNotFoundException("Product with ID "+id+" does not exist","PRODUCT_NOT_FOUND"));
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(productEntity,productResponse);
        return productResponse;
    }
}
