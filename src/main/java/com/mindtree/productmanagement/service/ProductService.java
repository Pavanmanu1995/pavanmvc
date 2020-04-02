package com.mindtree.productmanagement.service;

import java.util.List;

import com.mindtree.productmanagement.entity.Product;

public interface ProductService {

	List<Product> getProductDetails();

	void insertDataToProduct(Product product);

	Product getById(Long id);

	void deleteById(Long id);

}
