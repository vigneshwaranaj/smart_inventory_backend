package com.smart.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.inventory.entity.InvoiceItem;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {

}
