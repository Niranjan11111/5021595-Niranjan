package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return customer; // Return the created customer as a JSON response
    }
    
    @PostMapping("/register")
    public Customer registerCustomer(@RequestParam("name") String name,
                                     @RequestParam("email") String email,
                                     @RequestParam("address") String address) {
        Customer customer = new Customer();
        customer.setId((long) (customers.size() + 1)); // Simple ID generation
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);

        customers.add(customer);
        return customer; // Return the registered customer as a JSON response
    }

}
