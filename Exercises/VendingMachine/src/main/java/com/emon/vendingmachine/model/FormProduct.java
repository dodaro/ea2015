package com.emon.vendingmachine.model;

public class FormProduct {

	private boolean selected;
	private String name;
	private double price;
	
	
	public FormProduct(String name, double price) {
		this.name = name;
		this.price = price;
		this.selected = false;
	}

	public FormProduct() {
	}
	
	public boolean isSelected() {
		return selected;
	}

	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getPriceFormatted() {
		return String.format("%.2f", price);
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
