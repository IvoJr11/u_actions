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
public class Order {
  private Long id;
  private Long user_id;
  private Long stock_id;
  private double quantity;
  private double price;
  private State state;
  private LocalDateTime creationDate;
}
