package com.arcade.coreboot.service;

import com.arcade.coreboot.entity.Customer;
import jakarta.validation.Valid;

import java.util.List;


public interface CustomerService {
    List<Customer> findAll();

    List<Customer> findByName(String name);

    Customer findBySearch(String name, String email);

    Customer findByEmail(String email);

    void addCustomer(@Valid Customer customer);
}
