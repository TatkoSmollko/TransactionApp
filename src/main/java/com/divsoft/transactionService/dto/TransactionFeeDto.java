package com.divsoft.transactionService.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionFeeDto {
    private Double amount;
    private String currency;
    private Long transactionId;
}
