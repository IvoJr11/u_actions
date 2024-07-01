package com.myself.u_actions.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Stock {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private Company company;
  private Long quantity;
  private Long availableQuantity;
  private double price;
  private double totalValue;
}