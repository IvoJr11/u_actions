package com.myself.u_actions.dtos;

import java.util.Set;

import com.myself.u_actions.models.OrderStock;
import com.myself.u_actions.models.State;
import com.myself.u_actions.models.Transaction;

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
