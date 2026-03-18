package com.gemini.foms.service;

import com.gemini.foms.entity.Customer;
import com.gemini.foms.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void addCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
    }

    public Customer getCustomerByName(@PathVariable String name){
        return customerRepository.findByCustomerName(name);
    }

    public List<Customer> getAllByDate(@PathVariable LocalDate date){
        return customerRepository.findCustomersByDateOfRegister(date);
    }

    public List<Customer> getAllByRoomNo(@PathVariable String room){
        return customerRepository.findCustomersByCheckedInRoom(room);
    }


}
