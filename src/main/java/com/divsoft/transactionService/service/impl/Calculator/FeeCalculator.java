package com.divsoft.transactionService.service.impl.Calculator;

import com.divsoft.transactionService.model.Fee;
import com.divsoft.transactionService.model.Transaction;

public interface FeeCalculator {
     double calculateFee(Transaction transaction, Fee fee);
}
