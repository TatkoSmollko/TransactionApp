package com.divsoft.transactionService.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "transaction_type")
@Getter
@Setter
public class TransactionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @JsonManagedReference
    @OneToMany(mappedBy = "transactionType", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Fee> fees;

    @OneToMany(mappedBy = "transactionType", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Transaction> transactions;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TransactionType that = (TransactionType) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}

