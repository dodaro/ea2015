package it.unical.vendingMachine.model;

public class Good {

	private String name;
	private double price;
	
	public Good(String name, double price) {

		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
