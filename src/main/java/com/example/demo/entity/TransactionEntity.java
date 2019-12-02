package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private Double amount;

    @ManyToOne
    private  UserGroupEntity userGroupEntity;

    @ManyToOne
    private User paidBy;

    @Column
    private String date;

}
