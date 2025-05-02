package com.divsoft.transactionService.repository;

import com.divsoft.transactionService.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
