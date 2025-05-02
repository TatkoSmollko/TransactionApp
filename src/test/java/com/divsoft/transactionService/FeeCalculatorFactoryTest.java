package com.divsoft.transactionService;

import com.divsoft.transactionService.model.Fee;

import com.divsoft.transactionService.service.impl.Calculator.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class FeeCalculatorFactoryTest {

    @Test
    void whenFixedFee_thenReturnFixedFeeCalculator() {
        Fee fee = new Fee();
        fee.setFixedFee(10.0);

        FeeCalculator calculator = FeeCalculatorFactory.getCalculator(fee);

        assertInstanceOf(FixedFeeCalculator.class, calculator);
    }

    @Test
    void whenPercentFee_thenReturnPercentFeeCalculator() {
        Fee fee = new Fee();
        fee.setPercentFee(0.1);

        FeeCalculator calculator = FeeCalculatorFactory.getCalculator(fee);

        assertInstanceOf(PercentFeeCalculator.class, calculator);
    }

    @Test
    void whenBothFees_thenReturnCombinedFeeCalculator() {
        Fee fee = new Fee();
        fee.setFixedFee(10.0);
        fee.setPercentFee(0.1);

        FeeCalculator calculator = FeeCalculatorFactory.getCalculator(fee);

        assertInstanceOf(CombineFeeCalculator.class, calculator);
    }

    @Test
    void whenNoFees_thenThrowException() {
        Fee fee = new Fee(); // no fees set

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FeeCalculatorFactory.getCalculator(fee);
        });

        assertEquals("Unknown fee type", exception.getMessage());
    }
}
