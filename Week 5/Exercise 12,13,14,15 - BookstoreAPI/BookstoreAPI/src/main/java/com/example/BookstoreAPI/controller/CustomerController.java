package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.model.Customer;
import org.springframework.web.bind.annotation.*;
package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.exception.ResourceNotFoundException;
import com.example.BookstoreAPI.model.Book;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.mapper.BookMapper;

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();

    @PostMapping("/customers")
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        customer = customerRepository.save(customer);
        return new ResponseEntity<>(customerMapper.customerToCustomerDTO(customer), HttpStatus.CREATED);
    }
    
    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID " + id));
        return new ResponseEntity<>(customerMapper.customerToCustomerDTO(customer), HttpStatus.OK);
    }
    
    @PutMapping("/customers/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID " + id));

        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());

        customer = customerRepository.save(customer);
        return new ResponseEntity<>(customerMapper.customerToCustomerDTO(customer), HttpStatus.OK);
    }
    
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID " + id));

        customerRepository.delete(customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
