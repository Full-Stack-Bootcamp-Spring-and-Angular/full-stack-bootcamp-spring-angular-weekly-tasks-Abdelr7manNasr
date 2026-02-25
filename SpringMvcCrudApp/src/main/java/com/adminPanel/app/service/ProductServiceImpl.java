package com.adminPanel.app.service;

import com.adminPanel.app.dao.ProductDAO;
import com.adminPanel.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDAO productDAO;

//    private void validateName(Product product) {
//        if (product == null || product.getName() == null || product.getName().trim().isEmpty()) {
//            throw new RuntimeException("Product name is required");
//        }
//        product.setName(product.getName());
//    }
    @Override
    public void insert(Product product)
    {
//        validateName(product);
//        if (product.getProductDetails() == null) {
//            throw new RuntimeException("Product details is required");
//        }
//        if (product.getProductDetails().getPrice() <= 0) {
//            throw new RuntimeException("Invalid product price");
//        }
        productDAO.insert(product);
    }

    @Override
    public void update(Product product)
    {
//        validateName(product);
        productDAO.update(product);
    }

    @Override
    public void deleteById(int id)
    {
        Product product = productDAO.findById(id);
//        if (product == null) throw new RuntimeException("product id not found");
        productDAO.deleteById(id);
    }

    @Override
    public Product findById(int id)
    {
        return productDAO.findById(id);
    }

    @Override
    public List<Product> getAllProducts()
    {
        return productDAO.getAllProducts();
    }
}
