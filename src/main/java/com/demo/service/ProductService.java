package com.demo.service;

import org.springframework.data.domain.Page;

import com.demo.model.Product;

public interface ProductService {
	  
	    Page<Product> getAll(int page, int size);
	    Product create(Product product);
	    Product getById(Long id);
	    Product update(Long id, Product product);
	    void delete(Long id);
	  
	  
}