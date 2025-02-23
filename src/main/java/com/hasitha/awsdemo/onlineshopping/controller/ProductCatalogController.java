package com.hasitha.awsdemo.onlineshopping.controller;

import com.hasitha.awsdemo.onlineshopping.model.InstanceResponse;
import com.hasitha.awsdemo.onlineshopping.model.Product;
import com.hasitha.awsdemo.onlineshopping.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductCatalogController {

  private final ProductCatalogService productCatalogService;

  @Autowired
  public ProductCatalogController(ProductCatalogService productCatalogService) {
    this.productCatalogService = productCatalogService;
  }

  // Endpoint to get all products along with instance details
  @GetMapping
  public InstanceResponse getAllProducts() {
    List<Product> products = productCatalogService.getAllProducts();
    String instanceDetails = getInstanceDetails();
    return new InstanceResponse(products, instanceDetails);
  }

  // Endpoint to get a specific product by ID along with instance details
  @GetMapping("/{id}")
  public InstanceResponse getProductById(@PathVariable Long id) {
    Product product = productCatalogService.getProductById(id);
    String instanceDetails = getInstanceDetails();
    return new InstanceResponse(product, instanceDetails);
  }

  // Helper method to get instance details (host name, IP, etc.)
  private String getInstanceDetails() {
    try {
      InetAddress inetAddress = InetAddress.getLocalHost();
      return "Instance Host: " + inetAddress.getHostName() + ", IP: " + inetAddress.getHostAddress();
    } catch (UnknownHostException e) {
      return "Instance details unavailable";
    }
  }
}
