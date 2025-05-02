package com.divsoft.transactionService.repository;
import com.divsoft.transactionService.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface FeeRepository extends JpaRepository<Fee, Long> {
    Optional<Fee> findById(Long feeId);
}
