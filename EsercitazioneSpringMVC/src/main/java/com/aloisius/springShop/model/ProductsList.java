package com.aloisius.springShop.model;

import java.util.ArrayList;

public class ProductsList {
	private ArrayList<Product> products;
	
	public ProductsList() {
		products = Helper.getLoadedProducts();
	}
	
	public ProductsList(ArrayList<Product> products) {
		this.products = products;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

}
