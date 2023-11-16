package com.smart.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.inventory.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
