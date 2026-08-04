package com.gemini.foms.controller;

import com.gemini.foms.entity.Customer;
import com.gemini.foms.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(
            @Valid
            @RequestBody Customer customer){

        return service.create(customer);

    }

    @GetMapping
    public List<Customer> getAll() {
        return service.getAll();
    }
}
