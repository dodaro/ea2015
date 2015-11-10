package it.unical.vendingEa2015.model;

public class Good {
	private String name;
	private double price;
	
	public Good() {
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

	@Override
	public String toString() {
		return " " + name + " " + price + "€";
	}

}
