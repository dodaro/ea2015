package it.unical.example.model;

import java.util.List;

public class Store {

	private List<Product> products;
	private List<Product> colors;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Product> getColors() {
		return colors;
	}

	public void setColors(List<Product> colors) {
		this.colors = colors;
	}

}
