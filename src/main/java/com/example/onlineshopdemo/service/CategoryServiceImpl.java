package com.example.onlineshopdemo.service;

import com.example.onlineshopdemo.domain.Category;
import com.example.onlineshopdemo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void create(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return this.categoryRepository.getOne(id);
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }
}
