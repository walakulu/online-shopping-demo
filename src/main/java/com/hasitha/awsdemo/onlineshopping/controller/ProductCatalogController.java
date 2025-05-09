package com.hasitha.awsdemo.onlineshopping.controller;

import com.hasitha.awsdemo.onlineshopping.model.InstanceResponse;
import com.hasitha.awsdemo.onlineshopping.model.Product;
import com.hasitha.awsdemo.onlineshopping.service.ProductCatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductCatalogController {

  private static final Logger logger = LoggerFactory.getLogger(ProductCatalogController.class);

  private final ProductCatalogService productCatalogService;
  private final Environment environment;

  @Autowired
  public ProductCatalogController(ProductCatalogService productCatalogService, Environment environment) {
    this.productCatalogService = productCatalogService;
    this.environment = environment;
  }

  @GetMapping
  public InstanceResponse getAllProducts() {
    logger.info("Incoming request for getAllProducts");

    List<Product> products = productCatalogService.getAllProducts();
    String instanceDetails = getInstanceDetails();

    logger.info("Returning response with {} products from instance: {}", products.size(), instanceDetails);
    return new InstanceResponse(products, instanceDetails);
  }

  private String getInstanceDetails() {
    try {
      InetAddress inetAddress = InetAddress.getLocalHost();
      String port = environment.getProperty("local.server.port");  // Fetches actual running port
      return "Instance IP: " + inetAddress.getHostAddress() + ", Port: " + port;
    } catch (UnknownHostException e) {
      logger.error("Unable to get instance details", e);
      return "Instance details unavailable";
    }
  }
}
