package com.arcade.coreboot.controller;

import com.arcade.coreboot.entity.Customer;
import com.arcade.coreboot.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("")
    public List<Customer> getAllCustomers(){
        return customerService.findAll();
    }

    @GetMapping("/{name}")
    public List<Customer> getCustomerByName(@PathVariable("name") String name){
        return customerService.findByName(name);
    }
}

