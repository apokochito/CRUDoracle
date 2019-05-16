package com.example.demo.repository;

import com.example.demo.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private JpaProducts jpaProducts;

    @Autowired
    public ProductRepositoryImpl(JpaProducts jpaProducts){
        this.jpaProducts = jpaProducts;
    }

    @Override
    public List<ProductEntity> getProducts(){
        List<ProductEntity> response = jpaProducts.findAll();
        return response;
    }

    @Override
    public ProductEntity getProductById(long id){
        ProductEntity response = jpaProducts.findById(id).get();
        return response;
    }
}
