package com.divsoft.transactionService.service.impl.Fee;

import com.divsoft.transactionService.dto.FeeDto;
import com.divsoft.transactionService.dto.TransactionFeeDto;
import com.divsoft.transactionService.dto.TransactionTypeDto;
import com.divsoft.transactionService.model.Fee;
import com.divsoft.transactionService.model.TransactionType;
import com.divsoft.transactionService.repository.FeeRepository;
import com.divsoft.transactionService.service.impl.Transaction.TransactionService;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@AllArgsConstructor
@Service
public class FeeService {
    private final FeeRepository feeRepository;

    public FeeDto getFeeById(Long feeId) {
        return mapToFeeDto(feeRepository.findById(feeId).orElseThrow(() -> new ObjectNotFoundException("Fee", feeId)));
    }

    public FeeDto mapToFeeDto(Fee fee) {
        return FeeDto.builder()
                .id(fee.getId())
                .transactionType(mapToFeeDto(fee.getTransactionType()))
                .fixedFee(fee.getFixedFee())
                .percentFee(fee.getPercentFee())
                .validFrom(fee.getValidFrom())
                .validTo(fee.getValidTo())
                .build();
    }

    public TransactionTypeDto mapToFeeDto(TransactionType transactionType){
        return TransactionTypeDto.builder()
                .description(transactionType.getDescription())
                .id(transactionType.getId())
                .name(transactionType.getName())
                .build();
    }

}
