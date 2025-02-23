package com.hasitha.awsdemo.onlineshopping.controller;

import com.hasitha.awsdemo.onlineshopping.model.InstanceResponse;
import com.hasitha.awsdemo.onlineshopping.model.Product;
import com.hasitha.awsdemo.onlineshopping.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductCatalogController {

  private final ProductCatalogService productCatalogService;
  private final Environment environment;

  @Autowired
  public ProductCatalogController(ProductCatalogService productCatalogService, Environment environment) {
    this.productCatalogService = productCatalogService;
    this.environment = environment;
  }

  @GetMapping
  public InstanceResponse getAllProducts() {
    List<Product> products = productCatalogService.getAllProducts();
    String instanceDetails = getInstanceDetails();
    return new InstanceResponse(products, instanceDetails);
  }

  private String getInstanceDetails() {
    try {
      InetAddress inetAddress = InetAddress.getLocalHost();
      String port = environment.getProperty("local.server.port");  // Fetches actual running port
      return "Instance IP: " + inetAddress.getHostAddress() + ", Port: " + port;
    } catch (UnknownHostException e) {
      return "Instance details unavailable";
    }
  }
}
