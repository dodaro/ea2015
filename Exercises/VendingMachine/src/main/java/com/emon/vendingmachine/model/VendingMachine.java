package com.emon.vendingmachine.model;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
	private List<FormProduct> products;
	
	public VendingMachine() {
		this.products = new ArrayList<FormProduct>();
	}
	
	public List<FormProduct> getProducts() {
		return products;
	}
}
