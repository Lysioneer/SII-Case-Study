package com.sii.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Table(name = "transaction_data")
public class TransactionDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    private String transactionKey;

    @Setter
    private String transactionValue;

    @Setter
    @ManyToOne
    private TransactionEntity transaction;
}
