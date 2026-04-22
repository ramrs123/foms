package com.gemini.foms.controller;

import com.gemini.foms.entity.Customer;
import com.gemini.foms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public Customer create(@RequestBody Customer c) {
        return service.create(c);
    }

    @GetMapping
    public List<Customer> getAll() {
        return service.getAll();
    }
}
