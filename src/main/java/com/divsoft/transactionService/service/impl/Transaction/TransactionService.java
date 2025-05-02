package com.divsoft.transactionService.service.impl.Transaction;

import com.divsoft.transactionService.dto.TransactionFeeDto;
import com.divsoft.transactionService.model.Transaction;
import com.divsoft.transactionService.repository.TransactionRepository;
import com.divsoft.transactionService.service.impl.Calculator.FeeCalculator;
import com.divsoft.transactionService.service.impl.Calculator.FeeCalculatorFactory;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final FeeCalculatorFactory feeCalculatorFactory;


    @Transactional(readOnly = true)
    public TransactionFeeDto getFeesByTransactionId(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(()->new ObjectNotFoundException(Optional.of(transactionId),"transaction"));
        return mapToTransactionFeeDto(transaction);
    }

    @SuppressWarnings("static-access")
    private Double getFeesResult(Transaction transaction) {
        return transaction.getTransactionType().getFees().stream()
                .map(fee -> {
                    FeeCalculator feeCalculator = feeCalculatorFactory.getCalculator(fee);
                    return feeCalculator.calculateFee(transaction,fee);
                }).reduce(0.0, Double::sum);

    }

    public TransactionFeeDto mapToTransactionFeeDto(Transaction transaction) {
        return TransactionFeeDto.builder()
                .amount(getFeesResult(transaction))
                .transactionId(transaction.getId())
                .currency(transaction.getCurrency())
                .build();
    }
}
