package com.adminPanel.app.service;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import com.adminPanel.app.repository.ProductRepository;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct (Product product){
        if (product.getProductDetails() == null){
            ProductDetails productDetails = new ProductDetails();
            productDetails.setProduct(product);

            product.setProductDetails(productDetails);
        }
        else {
            product.getProductDetails().setProduct(product);
        }

        return productRepository.save(product);
    }

    public List<Product> getAllProducts (){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getProductByName(String name){
        return productRepository.findByName(name);
    }

    public void deleteProduct (Long id){
        productRepository.deleteById(id);
    }

    public Product updateProduct(Product product){
        Product productToUpdate =productRepository.findById(product.getId()).orElse(null);
        if(productToUpdate == null) {return null;}

        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());

        if(product.getProductDetails()!= null){
            ProductDetails detailsToUpdate = productToUpdate.getProductDetails();

            detailsToUpdate.setDescription(product.getProductDetails().getDescription());
            detailsToUpdate.setManufacturer(product.getProductDetails().getManufacturer());
        }
        return productRepository.save(productToUpdate);
    }
}
