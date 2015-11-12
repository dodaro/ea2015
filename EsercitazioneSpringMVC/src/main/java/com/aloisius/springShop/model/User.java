package com.aloisius.springShop.model;

public class User {
	private String name;
	private Product productSelected;
	private ProductColor productColorSelected;
		
	public User() {
		super();
	}	

	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product getProductSelected() {
		return productSelected;
	}

	public void setProductSelected(Product productSelected) {
		this.productSelected = productSelected;
	}

	public ProductColor getProductColorSelected() {
		return productColorSelected;
	}

	public void setProductColorSelected(ProductColor productColorSelected) {
		this.productColorSelected = productColorSelected;
	}
}
