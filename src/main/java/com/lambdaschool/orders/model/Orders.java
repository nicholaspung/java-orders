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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnoreProperties({"orders", "hibernateLazyInitializer"})
    private Customers customer;

    private String orddescription;

    public Orders() {
    }

    public Orders(double ordamount, double advanceamount, Customers customer, String orddescription) {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.customer = customer;
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
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public String getOrddescription() {
        return orddescription;
    }

    public void setOrddescription(String orddescription) {
        this.orddescription = orddescription;
    }
}
