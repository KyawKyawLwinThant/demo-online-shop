package com.example.onlineshopdemo.service;

import com.example.onlineshopdemo.domain.Products;
import com.example.onlineshopdemo.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {
    private final ProductsRepository productsRepository;

    public ProductsServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public Products create(Products products) {
        return productsRepository.save(products);
    }

    @Override
    public Products findById(int id) {
        return productsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Products> findAll() {
        return productsRepository.findAll();
    }

    @Override
    public List<Products> findProductsByCategoryid(int id) {
        return this.productsRepository.findProductsByCategoryId(id);
    }
}
