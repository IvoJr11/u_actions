package com.myself.u_actions.dtos;

import com.myself.u_actions.models.Order;

public class CreateTransactionDTO {
  private double stockQuantity;
  private double price;
  private Order order;
  
  public double getStockQuantity() {
    return stockQuantity;
  }
  public double getPrice() {
    return price;
  }
  public Order getOrder() {
    return order;
  }
}
