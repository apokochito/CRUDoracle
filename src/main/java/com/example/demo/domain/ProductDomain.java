package com.example.demo.domain;

import lombok.Data;

@Data
public class ProductDomain {
    private long id;
    private String name;
    private String brand;
    private int quantity;
}
