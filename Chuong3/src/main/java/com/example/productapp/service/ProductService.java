package com.example.productapp.service;

import com.example.productapp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Business layer: owns the product data and all operations on it.
 * The controller only routes HTTP requests to these methods.
 */
@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1, "Laptop", 15000000));
        products.add(new Product(2, "Mouse", 250000));
    }

    public List<Product> findAll() {
        return products;
    }

    public Product findById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void add(Product product) {
        product.setId(products.size() + 1);
        products.add(product);
    }

    public void delete(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    /** Case-insensitive search by name. Blank keyword returns all. */
    public List<Product> search(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return products;
        }
        String lower = keyword.toLowerCase();
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(lower))
                .toList();
    }
}
