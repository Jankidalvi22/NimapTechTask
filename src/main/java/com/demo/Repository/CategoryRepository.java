package com.demo.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	Page<Category> findAll(Pageable pageable);
}