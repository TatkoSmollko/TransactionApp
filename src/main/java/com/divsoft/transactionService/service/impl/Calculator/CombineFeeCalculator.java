package com.divsoft.transactionService.service.impl.Calculator;

import com.divsoft.transactionService.model.Fee;
import com.divsoft.transactionService.model.Transaction;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class CombineFeeCalculator implements FeeCalculator {
    @Override
    public double calculateFee(Transaction transaction, Fee fee) {
        return transaction.getAmount()/100 * fee.getPercentFee() + fee.getFixedFee() ;
    }
}
