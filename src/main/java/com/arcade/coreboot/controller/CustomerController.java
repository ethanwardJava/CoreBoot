package com.arcade.coreboot.controller;

import com.arcade.coreboot.entity.Customer;
import com.arcade.coreboot.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping("/")
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/all")
    public Page<Customer> getCustomers(Pageable pageable) {
        return customerService.findAllPage(pageable);
    }

    @GetMapping("/search")
    public Customer findCustomerByDetails(@RequestParam(required = false, defaultValue = "Alice") String name,
                                          @RequestParam(required = false) String email) {
        return customerService.findBySearch(name, email);
    }

    @GetMapping("/{name}")
    public List<Customer> getCustomerByName(@PathVariable("name") String name) {
        return customerService.findByName(name);
    }

    @GetMapping("/email")
    public Customer findCustomerByEmail(@RequestParam(name = "email") String email) {
        return customerService.findByEmail(email);
    }

    @PostMapping("/new")  /* Bug here fixed (I was Put mapping instead of Post mapping) */
    public String addUser(@RequestBody @Valid Customer customer) {
        customerService.addCustomer(customer);
        return "Success";
    }

}

