package com.divsoft.transactionService.service.impl.Calculator;

import com.divsoft.transactionService.model.Fee;
import org.springframework.stereotype.Component;

@Component
public class FeeCalculatorFactory {
    // in case of another CalculatorType the algorithm
    // can be updated to choose a calculator by transactionType
    public static FeeCalculator getCalculator(Fee fee) {
        if (fee.getFixedFee() != null && fee.getPercentFee() != null) {
            return new CombineFeeCalculator();
        } else if (fee.getFixedFee() != null ) {
            return new FixedFeeCalculator();
        } else if (fee.getPercentFee() != null) {
            return new PercentFeeCalculator();
        }
        throw new IllegalArgumentException("Unknown fee type");
    }
}

