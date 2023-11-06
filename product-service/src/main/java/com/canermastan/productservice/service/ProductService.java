package com.canermastan.productservice.service;

import com.canermastan.productservice.dto.ProductRequest;
import com.canermastan.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    void save(ProductRequest productRequest);
    List<ProductResponse> findAll();
}
