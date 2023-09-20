package com.sii.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashMap;

@Entity
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate timeStamp;

    private String type;

    private String author;

    private HashMap<String, String> transactionData;

}
