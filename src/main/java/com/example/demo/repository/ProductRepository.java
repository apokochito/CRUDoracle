package com.example.demo.repository;

import com.example.demo.entity.ProductEntity;

import java.util.List;

public interface ProductRepository {

    public List<ProductEntity> getProducts();

    public ProductEntity getProductById(long id);
}
