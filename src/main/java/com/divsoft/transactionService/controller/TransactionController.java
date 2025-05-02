package com.divsoft.transactionService.controller;

import com.divsoft.transactionService.dto.TransactionFeeDto;
import com.divsoft.transactionService.service.impl.Transaction.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/transaction")

public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/{id}")
    public TransactionFeeDto transaction(@PathVariable Long id) {
        return transactionService.getFeesByTransactionId(id);
    }
}
