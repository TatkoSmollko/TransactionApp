package com.divsoft.transactionService.service.impl.Calculator;

import com.divsoft.transactionService.model.Fee;
import com.divsoft.transactionService.model.Transaction;
import lombok.Data;

@Data
public class PercentFeeCalculator implements FeeCalculator {
    @Override
    public double calculateFee(Transaction transaction, Fee fee) {
        return transaction.getAmount()/100 * fee.getPercentFee() ;
    }
}
