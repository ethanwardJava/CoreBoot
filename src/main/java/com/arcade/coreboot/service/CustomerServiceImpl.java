package com.arcade.coreboot.service;

import com.arcade.coreboot.entity.Customer;
import com.arcade.coreboot.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = customerRepository.findAll();
        if (customers.isEmpty()) {
            return null;
        }
        return customers;

    }

    @Override
    public List<Customer> findByName(String name) {
        var customers = customerRepository.findByName(name);
        if (customers.isEmpty()) {
            return null;
        } return customerRepository.findByName(name);
    }

}
