package com.divsoft.transactionService.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactionsKafka")
public class TransactionKafkaController {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public TransactionKafkaController(KafkaTemplate<String, Object> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendTransaction(@RequestBody TransactionMessage message) throws JsonProcessingException {
        String jsonMessage = objectMapper.writeValueAsString(message);
        kafkaTemplate.send("transaction_topic", jsonMessage);
        return ResponseEntity.ok("Message sent to Kafka");
    }
}

