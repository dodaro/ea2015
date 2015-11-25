package com.aloisius.springShop.model;

public class Product {
	private String name;
//	private String imagePath;
	private String description;
	private float price;
//	private String colorSelected;
	
	public Product (){
		name = "";
//		imagePath = "";
		description = "";
		price = 0;
//		colorSelected = "orange";
	}
	
	public Product(String name, String description, float price) {
		super();
		this.name = name;
//		this.imagePath = imagePath;
		this.description = description;
		this.price = price;
	}	
	
	public Product(Product product) {
		super();
		this.name = product.getName();
//		this.imagePath = product.getImagePath();
		this.description = product.getDescription();
		this.price = product.getPrice();
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}
