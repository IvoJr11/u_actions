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
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String country;
  private LocalDate creationDate = LocalDate.now();
  private Role role;
  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  private Set<Portfolio> portfolios = new HashSet<>();
  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  private Set<Order> orders = new HashSet<>();
}
