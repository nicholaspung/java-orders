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

    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnoreProperties("orders")
    private Customers customers;

    private String orddescription;

    public Orders() {
    }

    public Orders(double ordamount, double advanceamount, Customers customers, String orddescription) {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.customers = customers;
        this.orddescription = orddescription;
    }

    public long getOrdnum() {
        return ordnum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public Customers getCustomer() {
        return customers;
    }

    public void setCustomer(Customers customers) {
        this.customers = customers;
    }

    public String getOrddescription() {
        return orddescription;
    }

    public void setOrddescription(String orddescription) {
        this.orddescription = orddescription;
    }
}
