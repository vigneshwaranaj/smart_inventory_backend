package com.smart.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.inventory.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
