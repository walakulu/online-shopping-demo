package com.hasitha.awsdemo.onlineshopping.service;

import com.hasitha.awsdemo.onlineshopping.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCatalogService {

  // In-memory product list (simulating a database)
  private final List<Product> products = new ArrayList<>();

  // Constructor to add sample data
  public ProductCatalogService() {
    products.add(new Product(1L, "Smartphone X", "A high-end smartphone", 799.99));
    products.add(new Product(2L, "Laptop Y", "A powerful gaming laptop", 1299.99));
    products.add(new Product(3L, "Smartwatch Z", "A smartwatch with health tracking", 199.99));
  }

  // Method to get all products
  public List<Product> getAllProducts() {
    return products;
  }

  // Method to get a single product by ID
  public Product getProductById(Long id) {
    return products.stream()
        .filter(product -> product.getId().equals(id))
        .findFirst()
        .orElse(null); // return null if not found
  }
}
