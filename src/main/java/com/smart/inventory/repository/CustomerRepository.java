package com.smart.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.inventory.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
