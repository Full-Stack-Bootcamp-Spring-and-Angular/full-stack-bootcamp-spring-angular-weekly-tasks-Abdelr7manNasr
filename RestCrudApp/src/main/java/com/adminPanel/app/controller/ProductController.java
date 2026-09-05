package com.adminPanel.app.controller;

import com.adminPanel.app.exception.ProductException;
import com.adminPanel.app.model.ErrorResponse;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import com.adminPanel.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/product")
    public Product insert(@RequestBody Product product) {
        productService.insert(product);
        return product;
    }

    @PutMapping(value = "/product")
    public Product update(@RequestBody Product product) {
        productService.update(product);
        return product;
    }

    @DeleteMapping(value = "/product")
    public String delete(@RequestParam Long  id) {
        productService.deleteById(id);
        return "Deleted";
    }

    @GetMapping(value = "/product")
    public Product getProduct(@RequestParam Long  id) throws ProductException {
        Product product = productService.findById(id);
        if(id >= 0 && product!=null)
            return product;
        throw new ProductException("Can not found this id");
    }

    @GetMapping(value = "/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value = "/product/details")
    public ProductDetails getProductDetails(@RequestParam Long  id ) throws ProductException {
        if(id >= 0 )
            return productService.findById(id).getProductDetails();
        throw new ProductException("Can not found this id for any details");

    }

    @GetMapping("/product/detailsByName")
    public List<Product> getByName(@RequestParam String name){
        return productService.findByName(name);
    }


}