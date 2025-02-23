package com.hasitha.awsdemo.onlineshopping.model;

public class InstanceResponse {
  private Object productData;
  private String instanceDetails;

  public InstanceResponse(Object productData, String instanceDetails) {
    this.productData = productData;
    this.instanceDetails = instanceDetails;
  }

  public Object getProductData() {
    return productData;
  }

  public void setProductData(Object productData) {
    this.productData = productData;
  }

  public String getInstanceDetails() {
    return instanceDetails;
  }

  public void setInstanceDetails(String instanceDetails) {
    this.instanceDetails = instanceDetails;
  }
}
