package com.example.onlineshopdemo.service;

import com.example.onlineshopdemo.domain.Category;

import java.util.List;

public interface CategoryService {
    void create(Category category);
    Category findById(int id);
    List<Category> findAll();
}
