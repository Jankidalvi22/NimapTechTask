package com.demo.service;



import org.springframework.data.domain.Page;

import com.demo.model.Category;

public interface CategoryService {
   
	 Page<Category> getAll(int page, int size);
	    Category create(Category category);
	    Category getById(Long id);
	    Category update(Long id, Category category);
	    void delete(Long id);

  
   
  
  
  
  
  
  
  
 
	
}