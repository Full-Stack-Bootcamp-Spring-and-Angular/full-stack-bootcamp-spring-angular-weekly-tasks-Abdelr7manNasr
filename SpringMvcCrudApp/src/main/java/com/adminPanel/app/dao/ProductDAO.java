package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;

import java.util.List;

public interface ProductDAO {

    Product insert(Product product);

    Product update(Product product);

    Product findById(int id);

    void deleteById(int id);

    List<Product> getAllProducts();
}