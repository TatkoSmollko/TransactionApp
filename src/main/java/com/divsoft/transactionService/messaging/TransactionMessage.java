package com.divsoft.transactionService.messaging;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TransactionMessage {
    private Long transactionId;
    private BigDecimal amount;
    private Long transactionTypeId;
    private LocalDate transactionDate;
}
