package com.demo.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	Page<Product> findAll(Pageable pageable);
}
