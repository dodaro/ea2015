package it.unical.distributore.model;

import java.util.ArrayList;

/*
 * this class contains the product list
 * filled in the root-context.xml
 */
public class Distributore {

	private ArrayList<Product> products;
	
	public Distributore() {
		
		this.setProducts(new ArrayList<Product>());
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
}
