package com.sii.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * Database entity for transaction.
 *
 * Created by Simek Jan on 21.9.2023.
 */
@Entity
@Getter
@Setter
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate timeStamp;

    private String type;

    private String actor;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    private List<TransactionDataEntity> transactionData;

}
