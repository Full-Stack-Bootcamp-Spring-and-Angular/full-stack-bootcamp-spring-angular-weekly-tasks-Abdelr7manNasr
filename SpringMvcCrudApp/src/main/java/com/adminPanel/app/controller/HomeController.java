package com.adminPanel.app.controller;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import com.adminPanel.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @InitBinder
    public void initBinder(WebDataBinder b) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        b.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }

    @RequestMapping("/")
    public String root() {
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String listProducts(Model model) {
        model.addAttribute("productsList", productService.getAllProducts());

        Product product = new Product();
        product.setProductDetails(new ProductDetails());
        model.addAttribute("productModel", product);

        return "homePage";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        Product product = new Product();
        product.setProductDetails(new ProductDetails());
        model.addAttribute("productModel", product);
        return "addProductForm";
    }

    @RequestMapping(value = "/processAddProduct", method = RequestMethod.POST)
    public String processAddProduct(@Valid @ModelAttribute("productModel") Product product, BindingResult result, Model model) {
        if (product.getProductDetails() == null) product.setProductDetails(new ProductDetails());
        if (result.hasErrors()) {
            return "addProductForm";
        }
        product.getProductDetails().setProduct(product);
        productService.insert(product);
        return "redirect:/list";
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.GET)
    public String showUpdateForm(@RequestParam("id") int id, Model model) {
        Product product = productService.findById(id);
        if (product == null) return "redirect:/list";
        if (product.getProductDetails() == null) product.setProductDetails(new ProductDetails());
        model.addAttribute("productModel", product);
        return "updateDetailsForm";
    }


    @RequestMapping(value = "/processUpdateProductForm", method = RequestMethod.POST)
    public String processUpdate(@Valid @ModelAttribute("productModel") Product product, BindingResult result, Model model) {
        if (product.getProductDetails() == null) product.setProductDetails(new ProductDetails());
        if (result.hasErrors()) {
            return "updateDetailsForm";
        }
        product.getProductDetails().setProduct(product);
        productService.update(product);
        return "redirect:/list";
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam("id") int id) {
        productService.deleteById(id);
        return "redirect:/list";
    }

    @RequestMapping(value = "/showProductDetails", method = RequestMethod.GET)
    public String showProductDetails(@RequestParam("id") int id, Model model) {
        Product product = productService.findById(id);
        if (product == null) return "redirect:/list";

        model.addAttribute("productModel", product);
        return "viewDetailsPage";
    }
}