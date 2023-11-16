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

import com.smart.inventory.entity.Inventory;
import com.smart.inventory.repository.InventoryRepository;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	
	 private final InventoryRepository inventoryRepository;
	 
	 @Autowired
	    public InventoryController(InventoryRepository inventoryRepository) {
	        this.inventoryRepository = inventoryRepository;
	    }
	 
	 @GetMapping
	    public List<Inventory> getAllInventries() {
	        return inventoryRepository.findAll();
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<Inventory> getInventyById(@PathVariable Long id) {
	        Optional<Inventory> inventory = inventoryRepository.findById(id);
	        return inventory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	 
	 @PostMapping
	    public Inventory createInventory(@RequestBody Inventory inventory) {
	        return inventoryRepository.save(inventory);
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<Inventory> updateInventory(@PathVariable Long id, @RequestBody Inventory updatedInventory) {
	        if (!inventoryRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        updatedInventory.setId(id);
	        Inventory savedProduct = inventoryRepository.save(updatedInventory);
	        return ResponseEntity.ok(savedProduct);
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteInventory(@PathVariable Long id) {
	        if (!inventoryRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        inventoryRepository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }

}
