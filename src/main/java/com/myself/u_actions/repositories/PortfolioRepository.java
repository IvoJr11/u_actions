package com.myself.u_actions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myself.u_actions.models.Portfolio;
import java.util.Optional;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long>{
  Optional<Portfolio> findById(Long id);
}
