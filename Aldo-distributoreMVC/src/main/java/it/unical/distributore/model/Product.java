package it.unical.distributore.model;

public class Product {

	private String name;
	private double price;
	private int id;
	private String label;
	
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabel() {
		return name + " " + price;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}
