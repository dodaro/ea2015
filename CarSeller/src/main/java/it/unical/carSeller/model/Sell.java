package it.unical.carSeller.model;

public class Sell {

	private String car;
	private String color;
	
	public Sell() {
		
	}
	
	public String getCar() {
		return car;
	}
	public void getCar(String name) {
		this.car = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public int getTotalPrice(){
		return PriceList.getPrice(car)+PriceList.getColorPrice(color);
	}
	
	
}
