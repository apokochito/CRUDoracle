package com.example.demo.service;

import com.example.demo.domain.ProductDomain;
import java.util.List;

public interface ProductService {

    public List<ProductDomain> getProducts();

    public ProductDomain getProductById(long id);
}
