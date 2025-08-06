package com.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.demo.Repository.CategoryRepository;
import com.demo.Repository.ProductRepository;
import com.demo.model.Category;
import com.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public Page<Product> getAll(int page, int size) {
        return productRepo.findAll(PageRequest.of(page, size));
    }

    @Override
    public Product create(Product product) {
        if (product.getCategory() != null && product.getCategory().getId() != null) {
            Optional<Category> category = categoryRepo.findById(product.getCategory().getId());
            category.ifPresent(product::setCategory);
        }
        return productRepo.save(product);
    }

    @Override
    public Product getById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public Product update(Long id, Product updatedProduct) {
        return productRepo.findById(id).map(product -> {
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());

            if (updatedProduct.getCategory() != null && updatedProduct.getCategory().getId() != null) {
                Optional<Category> category = categoryRepo.findById(updatedProduct.getCategory().getId());
                category.ifPresent(product::setCategory);
            }

            return productRepo.save(product);
        }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        productRepo.deleteById(id);
    }
}