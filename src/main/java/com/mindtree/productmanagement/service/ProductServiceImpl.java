package com.mindtree.productmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.mindtree.productmanagement.entity.Product;
import com.mindtree.productmanagement.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	public List<Product> getProductDetails()
	{
		return productRepo.findAll();
	}
	
	public void insertDataToProduct(Product product)
	{
		productRepo.save(product);
	}
	
	public Product getById(Long id)
	{
		return productRepo.findById(id).get();
	}
	
	public void deleteById(Long id)
	{
		productRepo.deleteById(id);
	}

}
