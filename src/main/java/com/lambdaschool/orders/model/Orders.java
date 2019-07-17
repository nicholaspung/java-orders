package com.lambdaschool.orders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

//    @Column(nullable = false)
//    private long ordnum;

    private double ordamount;
    private double advanceamount;
    private String orddescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnoreProperties({"orders", "hibernateLazyInitializer"})
    private Customers customer;
}
