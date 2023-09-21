package com.sii.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Database entity for transaction data.
 *
 * Created by Simek Jan on 21.9.2023.
 */
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
