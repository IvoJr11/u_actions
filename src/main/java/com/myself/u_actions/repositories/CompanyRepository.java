package com.myself.u_actions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myself.u_actions.models.Company;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long>{
  Optional<Company> findById(Long id);
  Optional<Company> findByName(String name);
}
