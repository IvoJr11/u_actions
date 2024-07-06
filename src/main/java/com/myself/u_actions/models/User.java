package com.myself.u_actions.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  private String password;
  private String country;
  private LocalDate creationDate = LocalDate.now();
  private Role role;
  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  private Set<Portfolio> portfolios = new HashSet<>();
  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  private Set<Order> orders = new HashSet<>();

  public User(String name, String email, String password, String country, Role role) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.country = country;
    this.role = role;
  }
}
