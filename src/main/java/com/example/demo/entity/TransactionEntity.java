package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column
    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    private  UserGroupEntity userGroupEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private User paidBy;

    @Column
    private String date;

    @Column
    long status;

}
