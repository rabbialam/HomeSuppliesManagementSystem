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

    @OneToOne
    private  UserGroupEntity userGroupEntity;

    @Column
    private String date;

}
