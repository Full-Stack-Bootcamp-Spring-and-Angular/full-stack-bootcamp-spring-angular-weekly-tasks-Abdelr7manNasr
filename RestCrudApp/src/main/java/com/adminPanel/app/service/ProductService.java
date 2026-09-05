package com.adminPanel.app.service;

import com.adminPanel.app.model.Product;

import java.util.List;

public interface ProductService {

    Product insert(Product product);

    Product update(Product product);

    void deleteById(Long  id);

    Product findById(Long  id);

    List<Product> getAllProducts();
    List<Product> findByName(String name);}