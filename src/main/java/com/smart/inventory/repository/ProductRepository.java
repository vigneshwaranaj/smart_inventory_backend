package com.smart.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.inventory.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
