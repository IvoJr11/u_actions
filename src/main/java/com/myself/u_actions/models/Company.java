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
@Table(name = "companies")
public class Company {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String location;
  private String identifier;
  private String sector;
  private double valuation;
  @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
  private Set<Stock> stocks = new HashSet<>();
}
