package com.adminPanel.app.service;

import com.adminPanel.app.model.Product;

import java.util.List;

public interface ProductService {

    void insert(Product product);

    void update(Product product);

    void deleteById(int id);

    Product findById(int id);

    List<Product> getAllProducts();
}