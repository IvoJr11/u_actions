package com.myself.u_actions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myself.u_actions.models.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findById(Long id);
  Optional<User> findByEmail(String email);
}
