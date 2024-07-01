package com.myself.u_actions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myself.u_actions.models.Stock;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long>{
  Optional<Stock> findById(Long id);
  Optional<Stock> findByName(String name);
}
