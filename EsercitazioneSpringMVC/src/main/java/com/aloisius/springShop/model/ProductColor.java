package com.aloisius.springShop.model;

public class ProductColor {
	private String name;
	private String imagePath;
	private float price;
	
	public ProductColor (){
		name = "";
		imagePath = "";
		price = 0.0f;
	}
	
	public ProductColor(String name, String imagePath, float price) {
		super();
		this.name = name;
		this.imagePath = imagePath;
		this.price = price;
	}	
	
	public ProductColor(ProductColor product) {
		super();
		this.name = product.getName();
		this.imagePath = product.getImagePath();
		this.price = product.getPrice();
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}
