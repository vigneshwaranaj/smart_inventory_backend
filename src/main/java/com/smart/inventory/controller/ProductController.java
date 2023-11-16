package com.smart.inventory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.inventory.entity.Product;
import com.smart.inventory.repository.ProductRepository;

@RestController
@CrossOrigin(origins = "http://localhost:54795")
@RequestMapping("/api/products")
public class ProductController {
	
	 private final ProductRepository productRepository;
	 
	 @Autowired
	    public ProductController(ProductRepository productRepository) {
	        this.productRepository = productRepository;
	    }
	 
	 @GetMapping
	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
	        Optional<Product> product = productRepository.findById(id);
	        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	 
	 @PostMapping
	    public Product createProduct(@RequestBody Product product) {
	        return productRepository.save(product);
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
	        if (!productRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        updatedProduct.setId(id);
	        Product savedProduct = productRepository.save(updatedProduct);
	        return ResponseEntity.ok(savedProduct);
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
	        if (!productRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        productRepository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }

}
