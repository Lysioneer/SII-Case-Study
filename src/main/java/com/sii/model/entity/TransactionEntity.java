package com.sii.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    private LocalDate timeStamp;

    @Setter
    private String type;

    @Setter
    private String actor;

    @Setter
    @OneToMany(mappedBy = "transaction")
    private List<TransactionDataEntity> transactionData;

}
