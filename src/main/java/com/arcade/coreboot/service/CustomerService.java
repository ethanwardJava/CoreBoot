package com.arcade.coreboot.service;

import com.arcade.coreboot.entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    List<Customer> findAll();
}
