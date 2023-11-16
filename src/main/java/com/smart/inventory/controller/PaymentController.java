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

import com.smart.inventory.entity.Invoice;
import com.smart.inventory.repository.InvoiceRepository;

@RestController
@RequestMapping("/api/invoice")
public class PaymentController {
	
	 private final InvoiceRepository invoiceRepository;
	 
	 @Autowired
	    public PaymentController(InvoiceRepository invoiceRepository) {
	        this.invoiceRepository = invoiceRepository;
	    }
	 
	 @GetMapping
	    public List<Invoice> getAllInvoices() {
	        return invoiceRepository.findAll();
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) {
	        Optional<Invoice> invoice = invoiceRepository.findById(id);
	        return invoice.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	 
	 @PostMapping
	    public Invoice createInvoice(@RequestBody Invoice invoice) {
	        return invoiceRepository.save(invoice);
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<Invoice> updateInvoice(@PathVariable Long id, @RequestBody Invoice updatedInvoice) {
	        if (!invoiceRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        updatedInvoice.setId(id);
	        Invoice savedInvoice = invoiceRepository.save(updatedInvoice);
	        return ResponseEntity.ok(savedInvoice);
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
	        if (!invoiceRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        invoiceRepository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }

}
