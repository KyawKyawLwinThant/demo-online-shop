package com.example.onlineshopdemo.service;

import com.example.onlineshopdemo.domain.Products;

import java.util.List;

public interface ProductsService {
    Products create(Products products);
    Products findById(int id);
    List<Products> findAll();

    List<Products> findProductsByCategoryid(int id);
}
