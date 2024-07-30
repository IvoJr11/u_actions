package com.myself.u_actions.models;

import java.util.Set;

public class CreateOrderDTO {
  private double quantity;
  private double price;
  private State state;
  private Set<Transaction> transactions;
  private Set<OrderStock> orderStocks;
  public double getQuantity() {
    return quantity;
  }
  public double getPrice() {
    return price;
  }
  public State getState() {
    return state;
  }
  public Set<Transaction> getTransactions() {
    return transactions;
  }
  public Set<OrderStock> getOrderStocks() {
    return orderStocks;
  }

}
