package com.gemini.foms.service;

import com.gemini.foms.entity.Customer;
import com.gemini.foms.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public Customer create(Customer c) {
        return repo.save(c);
    }

    public List<Customer> getAll() {
        return repo.findAll();
    }
}
