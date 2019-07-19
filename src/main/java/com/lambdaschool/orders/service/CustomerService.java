package com.lambdaschool.orders.service;

import com.lambdaschool.orders.model.Customers;
import com.lambdaschool.orders.model.Orders;

import java.util.List;

public interface CustomerService {
    List<Customers> findAllCustomersAndOrders();

    Customers findCustomerByName(String name);

    Customers save(Customers customer);

    Customers update(Customers customers, long custcode);

    void delete(long custcode);
}
