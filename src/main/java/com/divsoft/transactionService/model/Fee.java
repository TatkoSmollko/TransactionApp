package com.divsoft.transactionService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "fee")
@Data
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "transaction_type_id", nullable = false)
    private TransactionType transactionType;

    @Column(name = "fixed_fee")
    private Double fixedFee;

    @Column(name = "percent_fee")
    private Double percentFee;

    @Column(name = "valid_from")
    private LocalDate validFrom = LocalDate.now();

    @Column(name = "valid_to")
    private LocalDate validTo;

}

