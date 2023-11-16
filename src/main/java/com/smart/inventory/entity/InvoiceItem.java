package com.smart.inventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice_item")
public class InvoiceItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "invoice_id")
	private Long invoiceId;
	
	@Column(name = "product_id")
	private Long productId;
	
	private Long quantity;

	@Column(name = "item_amount")
	private Float itemAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Float getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(Float itemAmount) {
		this.itemAmount = itemAmount;
	}

	@Override
	public String toString() {
		return "InvoiceItem [id=" + id + ", invoiceId=" + invoiceId + ", productId=" + productId + ", quantity="
				+ quantity + ", itemAmount=" + itemAmount + "]";
	}
	
	

}
