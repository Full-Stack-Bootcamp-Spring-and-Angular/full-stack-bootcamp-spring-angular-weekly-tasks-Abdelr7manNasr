package com.adminPanel.app.service;

import com.adminPanel.app.dao.ProductDAO;
import com.adminPanel.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    private void validateName(Product product) {
        if (product == null || product.getName() == null || product.getName().trim().isEmpty()) {
            throw new RuntimeException("Product name is required");
        }
        product.setName(product.getName());
    }

    @Override
    public Product insert(Product product) {

        validateName(product);

        if (product.getProductDetails() == null)
            throw new RuntimeException("Product details is required");

        if (product.getPrice() <= 0)
            throw new RuntimeException("Invalid product price");

        product.getProductDetails().setProduct(product);

        productDAO.insert(product);

        return product;
    }

    @Override
    public Product update(Product product) {

        validateName(product);

        if(product.getProductDetails()!=null){
            product.getProductDetails().setProduct(product);
        }

        productDAO.update(product);

        return product;
    }

    @Override
    public void deleteById(Long  id) {
        Product product = productDAO.findById(id);
        if (product == null) throw new RuntimeException("product id not found");
        productDAO.deleteById(id);
    }

    @Override
    public Product findById(Long  id) {
        return productDAO.findById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public List<Product> findByName(String name){
        return productDAO.findByName(name);
    }
}
