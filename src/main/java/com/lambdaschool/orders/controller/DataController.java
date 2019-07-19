package com.lambdaschool.orders.controller;

import com.lambdaschool.orders.model.Customers;
import com.lambdaschool.orders.service.CustomerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/customer/new", produces = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid @RequestBody Customers customers) throws URISyntaxException {
        customerService.save(customers);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value ="/customer/update/{custcode}", produces = {"application/json"})
    public ResponseEntity<?> updateCustomer(@RequestBody Customers updateCustomers, @PathVariable long custcode) {
        customerService.update(updateCustomers, custcode);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/customer/delete/{custcode}", produces = {"application/json"})
    public ResponseEntity<?> deleteCustomer(@PathVariable long custcode) {
        customerService.delete(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
