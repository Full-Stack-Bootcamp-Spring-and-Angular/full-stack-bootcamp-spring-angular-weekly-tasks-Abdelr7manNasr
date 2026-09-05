package com.adminPanel.app.controller;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SpringProductApis")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @PostMapping(value = "product")
    public Product createProduct (@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping(value = "products")
    public List<Product> getAllProducts (){
        return productService.getAllProducts();
    }
    @GetMapping(value = "product")
    public Product getProductById(@RequestParam Long id){
        return productService.getProductById(id);
    }

    @GetMapping(value = "productByName")
    public List<Product> getProductByName(@RequestParam String name){
        return productService.getProductByName(name);
    }

    @DeleteMapping(value = "product")
    public void deleteProduct (@RequestParam Long id){
        productService.deleteProduct(id);
    }

    @PutMapping(value = "product")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }
}
