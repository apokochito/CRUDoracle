package com.example.demo.service;

import com.example.demo.config.OrikaMapper;
import com.example.demo.domain.ProductDomain;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepositoryImpl;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepositoryImpl repository;
    private MapperFacade facade = new OrikaMapper();

    @Autowired
    public ProductServiceImpl(ProductRepositoryImpl repository){
        this.repository = repository;
    }

    public List<ProductDomain> getProducts(){
        List<ProductEntity> entity = repository.getProducts();
        List<ProductDomain>  domain = new ArrayList<>();
        entity.stream().forEach((product)-> {
            domain.add(facade.map(product, ProductDomain.class));
        });
        return domain;
    }

    public ProductDomain getProductById(long id){
        ProductDomain domain = new ProductDomain();
        ProductEntity entity = repository.getProductById(id);
        domain = facade.map(entity,ProductDomain.class);
        return domain;
    }

}
