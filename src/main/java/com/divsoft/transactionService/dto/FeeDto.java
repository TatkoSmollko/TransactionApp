package com.divsoft.transactionService.dto;

import com.divsoft.transactionService.model.TransactionType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class FeeDto {
    private Long id;
    private TransactionTypeDto transactionType;
    private Double fixedFee;
    private Double percentFee;
    private LocalDate validFrom = LocalDate.now();
    private LocalDate validTo;
}
