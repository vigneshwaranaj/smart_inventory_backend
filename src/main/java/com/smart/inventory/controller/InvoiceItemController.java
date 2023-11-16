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

import com.smart.inventory.entity.InvoiceItem;
import com.smart.inventory.repository.InvoiceItemRepository;

@RestController
@RequestMapping("/api/invoiceItem")
public class InvoiceItemController {
	
	 private final InvoiceItemRepository invoiceItemRepository;
	 
	 @Autowired
	    public InvoiceItemController(InvoiceItemRepository invoiceItemRepository) {
	        this.invoiceItemRepository = invoiceItemRepository;
	    }
	 
	 @GetMapping
	    public List<InvoiceItem> getAllInvoiceItems() {
	        return invoiceItemRepository.findAll();
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<InvoiceItem> getInvoiceItemById(@PathVariable Long id) {
	        Optional<InvoiceItem> invoiceItem = invoiceItemRepository.findById(id);
	        return invoiceItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	 
	 @PostMapping
	    public InvoiceItem createInvoiceItem(@RequestBody InvoiceItem invoiceItem) {
	        return invoiceItemRepository.save(invoiceItem);
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<InvoiceItem> updateInvoiceItem(@PathVariable Long id, @RequestBody InvoiceItem updatedInvoiceItem) {
	        if (!invoiceItemRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        updatedInvoiceItem.setId(id);
	        InvoiceItem savedInvoiceItem = invoiceItemRepository.save(updatedInvoiceItem);
	        return ResponseEntity.ok(savedInvoiceItem);
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
	        if (!invoiceItemRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        invoiceItemRepository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }

}
