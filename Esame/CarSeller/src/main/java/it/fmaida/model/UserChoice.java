package it.fmaida.model;

public class UserChoice {

	private String car;
	private String color;
	private int totalPrice;
	
	public UserChoice() {
		this.totalPrice = 0;
	}
	
	public String getCar() {
		return car;
	}
	
	public void setCar(String car) {
		this.car = car;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	
	@Override
	public String toString() {
		return "[car = " + car + ", color = " + color + ", totalPrice = " + totalPrice + "]";  
	}

	
}
