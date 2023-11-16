package com.smart.inventory.entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String sku;

	private String description;

	@Column(name = "cost_price")
	private Float costPrice;

	@Column(name = "selling_price")
	private Float sellingPrice;

	@Column(name = "reorder_quantity")
	private Long reorderQuantity;

	private String unit;

	@Column(name = "supplier_id")
	private Long supplierId;
	
	@CreationTimestamp
	@Column(name = "created_date")
	private Date createdDate;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Float costPrice) {
		this.costPrice = costPrice;
	}

	public Float getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Long getReorderQuantity() {
		return reorderQuantity;
	}

	public void setReorderQuantity(Long reorderQuantity) {
		this.reorderQuantity = reorderQuantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", sku=" + sku + ", description=" + description + ", costPrice="
				+ costPrice + ", sellingPrice=" + sellingPrice + ", reorderQuantity=" + reorderQuantity + ", unit="
				+ unit + ", supplierId=" + supplierId + ", createdDate=" + createdDate + "]";
	}

	

}
