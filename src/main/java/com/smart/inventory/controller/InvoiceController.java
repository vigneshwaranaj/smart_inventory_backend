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

import com.smart.inventory.entity.Payment;
import com.smart.inventory.repository.PaymentRepository;

@RestController
@RequestMapping("/api/payment")
public class InvoiceController {
	
	 private final PaymentRepository paymentRepository;
	 
	 @Autowired
	    public InvoiceController(PaymentRepository paymentRepository) {
	        this.paymentRepository = paymentRepository;
	    }
	 
	 @GetMapping
	    public List<Payment> getAllPayments() {
	        return paymentRepository.findAll();
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
	        Optional<Payment> payment = paymentRepository.findById(id);
	        return payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	 
	 @PostMapping
	    public Payment createPayment(@RequestBody Payment payment) {
	        return paymentRepository.save(payment);
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
	        if (!paymentRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        updatedPayment.setId(id);
	        Payment savedPayment = paymentRepository.save(updatedPayment);
	        return ResponseEntity.ok(savedPayment);
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
	        if (!paymentRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        paymentRepository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }

}
