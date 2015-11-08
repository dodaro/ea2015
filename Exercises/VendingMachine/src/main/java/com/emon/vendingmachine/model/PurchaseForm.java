package com.emon.vendingmachine.model;

import java.util.ArrayList;
import java.util.List;

public class PurchaseForm {
	
	private List<FormProduct> products;
	private double amount;
	
	public PurchaseForm() {
		this.products = new ArrayList<FormProduct>();
		
		products.add(new FormProduct("Coffee", 0.80));
		products.add(new FormProduct("Macchiato", 0.80));
		products.add(new FormProduct("Hot Chocolate", 1.50));
		products.add(new FormProduct("Hot Tea", 1.20));
		products.add(new FormProduct("Hot Milk", 1.00));
	}
	
	public double getAmount() {
		return amount;
	}

	public String getAmountFormatted() {
		return String.format("%.2f", amount);
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public List<FormProduct> getProducts() {
		return products;
	}
}
