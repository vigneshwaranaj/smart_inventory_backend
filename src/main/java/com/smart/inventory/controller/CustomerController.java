package com.smart.inventory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.inventory.entity.Customer;
import com.smart.inventory.entity.Product;
import com.smart.inventory.repository.CustomerRepository;
import com.smart.inventory.repository.ProductRepository;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	 private final CustomerRepository repository;
	 
	 @Autowired
	    public CustomerController(CustomerRepository repository) {
	        this.repository = repository;
	    }
	 
	 @GetMapping
	    public List<Customer> getAll() {
	        return repository.findAll();
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<Customer> getById(@PathVariable Long id) {
	        Optional<Customer> customer = repository.findById(id);
	        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	 
	 @PostMapping
	    public Customer create(@RequestBody Customer customer) {
	        return repository.save(customer);
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer updated) {
	        if (!repository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        updated.setId(id);
	        Customer saved = repository.save(updated);
	        return ResponseEntity.ok(saved);
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id) {
	        if (!repository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        repository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }

}
