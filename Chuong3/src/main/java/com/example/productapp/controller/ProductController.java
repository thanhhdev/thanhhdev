package com.example.productapp.controller;

import com.example.productapp.model.Product;
import com.example.productapp.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    // Constructor injection: Spring passes the ProductService bean automatically.
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public String listProducts(@RequestParam(required = false) String keyword, Model model) {
        model.addAttribute("products", service.search(keyword));
        model.addAttribute("keyword", keyword);
        return "products";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/add")
    public String addProduct(
            @Valid @ModelAttribute Product product,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "add-product";
        }
        service.add(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}")
    public String productDetail(@PathVariable int id, Model model) {
        model.addAttribute("product", service.findById(id));
        return "product-detail";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        service.delete(id);
        return "redirect:/products";
    }
}
