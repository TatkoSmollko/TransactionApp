package com.divsoft.transactionService.controller;

import com.divsoft.transactionService.dto.FeeDto;
import com.divsoft.transactionService.dto.TransactionFeeDto;
import com.divsoft.transactionService.service.impl.Fee.FeeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/fee")
public class FeeController {
    private final FeeService feeService;

    @GetMapping("/{id}")
    public FeeDto transaction(@PathVariable Long id) {
        return feeService.getFeeById(id);
    }
}
