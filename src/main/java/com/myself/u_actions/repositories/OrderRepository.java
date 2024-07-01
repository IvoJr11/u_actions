package com.myself.u_actions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myself.u_actions.models.Order;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
  Optional<Order> findById(Long id);
}
