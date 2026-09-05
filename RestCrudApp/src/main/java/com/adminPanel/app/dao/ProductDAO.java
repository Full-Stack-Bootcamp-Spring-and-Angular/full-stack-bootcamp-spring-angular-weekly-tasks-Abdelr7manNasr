package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;

import java.util.List;

public interface ProductDAO {

    Product insert(Product product);

    Product update(Product product);

    Product findById(Long  id);

    void deleteById(Long  id);

    List<Product> getAllProducts();

    List<Product> findByName(String name);}