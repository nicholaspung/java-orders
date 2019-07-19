package com.lambdaschool.orders.controller;

import com.lambdaschool.orders.model.Customers;
import com.lambdaschool.orders.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/order", produces = {"application/json"})
    public ResponseEntity<?> getAllCustomersAndOrders() {
        List<Customers> myCustomers = customerService.findAllCustomersAndOrders();
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }

    @GetMapping(value = "/name/{custname}", produces = {"application/json"})
    public ResponseEntity<?> getCustomerByName(@PathVariable String custname) {
        Customers c = customerService.findCustomerByName(custname);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
}
