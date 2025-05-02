package com.divsoft.transactionService.service.impl;

import com.divsoft.transactionService.dto.TransactionFeeDto;
import com.divsoft.transactionService.messaging.TransactionMessage;
import com.divsoft.transactionService.service.impl.Fee.FeeService;
import com.divsoft.transactionService.service.impl.Transaction.TransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class FeeConsumerService {

    private final ObjectMapper objectMapper;
    private final TransactionService transactionService;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public FeeConsumerService(ObjectMapper objectMapper, FeeService feeService, TransactionService transactionService, KafkaTemplate<String, Object> kafkaTemplate) {
        this.objectMapper = objectMapper;
        this.transactionService = transactionService;
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "transaction_topic", groupId = "fee-service-group")
    public void listen(String message) throws JsonProcessingException {
        TransactionMessage transaction = objectMapper.readValue(message, TransactionMessage.class);
        TransactionFeeDto dto = transactionService.getFeesByTransactionId(transaction.getTransactionId());
        kafkaTemplate.send("fee_result_topic", objectMapper.writeValueAsString(dto));
    }

}

