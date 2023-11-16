package com.smart.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.inventory.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
