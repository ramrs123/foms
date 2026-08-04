package com.gemini.foms.service;

import com.gemini.foms.entity.Customer;
import com.gemini.foms.exception.DuplicateCustomerException;
import com.gemini.foms.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer create(Customer customer) {

        customer.setName(customer.getName().trim());
        customer.setPhone(customer.getPhone().trim());

        if(customerRepository.existsByPhone(customer.getPhone())) {
            throw new DuplicateCustomerException(
                    "Phone number already exists.");
        }

        return customerRepository.save(customer);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer getById(Long id) {

        return customerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found."));
    }

}
