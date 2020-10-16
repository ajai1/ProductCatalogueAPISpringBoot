package com.ajai.restful.productcatalogue.entity;


import javax.persistence.*;

@Entity
@Table(name="Product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	String name;
	String desc;
	String supplier;
	String productType;
	double unitPrice;
	long unitsInStrock;
	
	public Product() {
		
	}
	
	public Product(long id, String name, String desc, String supplier, String productType, double unitPrice,
			long unitsInStrock) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.supplier = supplier;
		this.productType = productType;
		this.unitPrice = unitPrice;
		this.unitsInStrock = unitsInStrock;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getsupplier() {
		return supplier;
	}
	public void setsupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public long getUnitsInStrock() {
		return unitsInStrock;
	}
	public void setUnitsInStrock(long unitsInStrock) {
		this.unitsInStrock = unitsInStrock;
	}
	
	
}
