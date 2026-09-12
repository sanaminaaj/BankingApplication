package com.fis.banking_parent.com.fis.banking_parent.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.banking_parent.com.fis.banking_parent.entity.Customer;
import com.fis.banking_parent.com.fis.banking_parent.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	  private final CustomerService customerService;

	    public CustomerController(CustomerService customerService) {
	        this.customerService = customerService;
	    }

	    // US-006: Register a new customer
	    @PostMapping
	    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) 		{
	        Customer savedCustomer = customerService.registerCustomer(customer);
	        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
	    }

	    // US-007: View customer details
	    @GetMapping("/{id}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
	        Customer customer = customerService.getCustomer(id);
	        return ResponseEntity.ok(customer);
	    }

	    // US-008: Update customer profile
	    @PutMapping("/{id}")
	    public ResponseEntity<Customer> updateCustomer(
	            @PathVariable Long id,
	            @RequestBody Customer customer) {

	        Customer updatedCustomer = customerService.update(id, customer);
	        return ResponseEntity.ok(updatedCustomer);
	    }

	    // US-009: Delete customer
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
	        customerService.delete(id);
	        return ResponseEntity.ok("Customer deleted successfully.");
	    }	
}
