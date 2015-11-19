package it.unical.carseller.model;

public class Car {
	
	private String model;
	private double price;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return model + " (" + price + " euro)";
	}

}
