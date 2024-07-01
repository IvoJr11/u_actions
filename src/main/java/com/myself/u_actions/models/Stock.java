package com.myself.u_actions.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stocks")
public class Stock {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private Long quantity;
  private Long availableQuantity;
  private double price;
  private double totalValue;
  @OneToMany(mappedBy = "stock", fetch = FetchType.EAGER)
  private Set<OrderStock> orderStocks = new HashSet<>();
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "company_id")
  private Company company;
  @OneToMany(mappedBy = "stock", fetch = FetchType.EAGER)
  private Set<PortfolioStock> portfolioStock = new HashSet<>();
}
