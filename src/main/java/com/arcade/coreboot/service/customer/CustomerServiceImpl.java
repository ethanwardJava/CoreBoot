package com.arcade.coreboot.service.customer;

import com.arcade.coreboot.entity.Customer;
import com.arcade.coreboot.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        return customers.isEmpty() ? List.of() : customers;
    }


    @Override
    public Customer findBySearch(String name, String email) {
        var customers = customerRepository.findByNameAndEmail(name, email);
        if (customers.isEmpty()) {
            return null;
        }
        return customers.stream().findFirst().orElse(null);
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }



    @Override
    public Page<Customer> findAllPage(Pageable pageable) {
        // default to page 0, size 10 if pageable is null
        Pageable effectivePageable = (pageable == null) ? PageRequest.of(0, 10) : pageable;
        return customerRepository.findAll(effectivePageable);
    }



}
