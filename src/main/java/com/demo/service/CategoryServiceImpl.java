package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.demo.Repository.CategoryRepository;
import com.demo.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public Page<Category> getAll(int page, int size) {
        return categoryRepo.findAll(PageRequest.of(page, size));
    }

    @Override
    public Category create(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category getById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public Category update(Long id, Category updatedCategory) {
        return categoryRepo.findById(id).map(category -> {
            category.setName(updatedCategory.getName());
            return categoryRepo.save(category);
        }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }
}