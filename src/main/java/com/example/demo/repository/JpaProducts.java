package com.example.demo.repository;

import com.example.demo.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProducts extends JpaRepository<ProductEntity, Long> {
}
