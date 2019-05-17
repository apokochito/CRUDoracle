package com.example.demo.controller;

import com.example.demo.domain.ProductDomain;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pega")
public class ProductController {

    private ProductServiceImpl service;

    @Autowired
    public ProductController(ProductServiceImpl service){
        this.service = service;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value= "/products")
    public List<ProductDomain> getProducts(){
        List<ProductDomain> response = service.getProducts();
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/products/{id}")
    public ProductDomain getProductById(@PathVariable(value="id", required = true)long id){
        ProductDomain response = service.getProductById(id);
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/product")
    @ResponseBody
    public ProductDomain getProductByName(@RequestParam String name, @RequestParam String brand){
        ProductDomain response = service.getProductByName(name, brand);
        return response;
    }
    //@Valid Para bautizar un dato extraño como válido.
}
