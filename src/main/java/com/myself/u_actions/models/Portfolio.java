package com.myself.u_actions.models;
import java.time.LocalDate;
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
@Table(name = "portfolios")
public class Portfolio {
  @Id
  @GeneratedValue
  private Long id;
  private LocalDate creationDate = LocalDate.now();
  private double totalValue;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
  @OneToMany(mappedBy = "portfolio", fetch = FetchType.EAGER)
  private Set<PortfolioStock> portfolioStock = new HashSet<>();
}

