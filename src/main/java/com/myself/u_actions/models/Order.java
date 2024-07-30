package com.myself.u_actions.models;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue
  private Long id;
  private double quantity;
  private double price;
  private State state;
  private LocalDate creationDate = LocalDate.now();
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  private User user;
  @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
  private Set<Transaction> transactions = new HashSet<>();
  @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
  private Set<OrderStock> orderStocks = new HashSet<>();

  public Order(double quantity, double price, State state, User user, Set<Transaction> transactions, Set<OrderStock> orderStocks) {
    this.quantity = quantity;
    this.price = price;
    this.state = state;
    this.user = user;
    this.transactions = transactions;
    this.orderStocks = orderStocks;
  }
}
