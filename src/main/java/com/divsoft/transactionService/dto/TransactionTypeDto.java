package com.divsoft.transactionService.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionTypeDto {
    private Long id;
    private String name;
    private String description;
}
