//package com.divsoft.transactionService;
//
//import com.divsoft.transactionService.dto.TransactionFeeDto;
//import com.divsoft.transactionService.model.Fee;
//import com.divsoft.transactionService.model.Transaction;
//import com.divsoft.transactionService.model.TransactionType;
//import com.divsoft.transactionService.repository.FeeRepository;
//import com.divsoft.transactionService.repository.TransactionRepository;
//import com.divsoft.transactionService.repository.TransactionTypeRepository;
//import com.divsoft.transactionService.service.impl.Transaction.TransactionService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@AutoConfigureTestDatabase
//@Transactional
//class TransactionServiceIT {
//
//    @Autowired
//    private TransactionRepository transactionRepository;
//
//    @Autowired
//    private TransactionTypeRepository transactionTypeRepository;
//
//    @Autowired
//    private FeeRepository feeRepository;
//
//    @Autowired
//    private TransactionService transactionService;
//
//    @Test
//    void getFeesByTransactionId_shouldCalculateFeeCorrectly() {
//        // Setup TransactionType and Fee
//        TransactionType type = new TransactionType();
//        type = transactionTypeRepository.save(type);
//
//        Fee fee = new Fee();
//        fee.setFixedFee(10.0);
//        fee.setPercentFee(null);
//        fee.setTransactionType(type);
//        feeRepository.save(fee);
//
//        type.setFees(Set.of(fee));
//        transactionTypeRepository.save(type);
//
//        // Setup Transaction
//        Transaction transaction = new Transaction();
//        transaction.setAmount(100.0);
//        transaction.setCurrency("EUR");
//        transaction.setTransactionType(type);
//        transaction = transactionRepository.save(transaction);
//
//        // Execute
//        TransactionFeeDto dto = transactionService.getFeesByTransactionId(transaction.getId());
//
//        // Verify
//        assertEquals(transaction.getId(), dto.getTransactionId());
//        assertEquals("EUR", dto.getCurrency());
//        assertEquals(10.0, dto.getAmount());
//    }
//}
