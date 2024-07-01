package com.myself.u_actions.models;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {
  private Long id;
  private Long user_id;
  private Long stock_id;
  private LocalDateTime creationDate = LocalDateTime.now();
  private double stockQuantity;
  private double price;
}
