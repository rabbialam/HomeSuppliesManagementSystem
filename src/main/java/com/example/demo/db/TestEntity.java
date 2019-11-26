package com.example.demo.db;

import javax.persistence.*;

@Entity
public class TestEntity {
    @Column
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)




    private Long id;
}
