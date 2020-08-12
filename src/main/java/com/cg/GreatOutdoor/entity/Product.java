package com.cg.GreatOutdoor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="great_outdoor_product")
public class Product {
	@Id
	@Column(name="product_Id")
	private long productId;
	
	@Column(name="price",length=5)
	private double price;
	
	@Column(name="colour",length=7)
	private String colour;
	
	
	@Column(name="specification",length=15)
	private String specification;
	
	@Column(name="maufacturer",length=10)
	private String manufacturer;
	
	@Column(name="quantity",length=3)
	private int quantity;
	
	@Column(name="product_Category",length=10)
	private int productCategory;
	
	@Column(name="product_Name",length=10)
	private String productName;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	

}
