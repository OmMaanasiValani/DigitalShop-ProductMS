package com.digitalshop.ProductService.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private long productId;

    private String product_name;

    private long price;

    private long quantity;
}
