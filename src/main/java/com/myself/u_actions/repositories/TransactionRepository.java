package com.myself.u_actions.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.myself.u_actions.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
  Optional<Transaction> findById(Long id);
}
