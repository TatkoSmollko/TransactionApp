package com.divsoft.transactionService.service.impl.Calculator;

import com.divsoft.transactionService.model.Fee;
import com.divsoft.transactionService.model.Transaction;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class FixedFeeCalculator implements FeeCalculator {

    @Override
    public double calculateFee(Transaction transaction, Fee fee) {
        return fee.getFixedFee();
    }
}
