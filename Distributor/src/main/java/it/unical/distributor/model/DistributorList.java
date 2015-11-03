package it.unical.distributor.model;

import java.util.ArrayList;

public class DistributorList {
	private int dimension;
	private ArrayList<Product> products;
	
	public DistributorList(){
		dimension = 4;
		products = new ArrayList<Product>(dimension);
		
		products.add(new Product("Coffee", 0.5f));
		products.add(new Product("Milk", 0.8f));
		products.add(new Product("Sugar Fruit", 1.0f));
		products.add(new Product("Tea", 0.6f));
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
}
