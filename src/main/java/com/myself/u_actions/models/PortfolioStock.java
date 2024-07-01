package com.myself.u_actions.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PortfolioStock {
  @Id
  @GeneratedValue
  private Long id;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "portfolio_id")
  private Portfolio portfolio;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "stock_id")
  private Stock stock;
}
