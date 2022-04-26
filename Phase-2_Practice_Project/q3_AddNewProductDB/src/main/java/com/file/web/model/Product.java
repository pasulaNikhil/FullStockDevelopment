package com.file.web.model;

public class Product {
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", company=" + company + "]";
	}

	int id;
	String name;
	String company;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
	public Product(int id, String name, String company) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
	}
	
	public Product() {
		super();
		
	}
	
	
	
	

}
