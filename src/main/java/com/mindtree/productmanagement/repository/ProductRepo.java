package com.mindtree.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.productmanagement.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
