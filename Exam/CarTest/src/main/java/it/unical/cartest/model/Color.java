package it.unical.cartest.model;

import java.util.Random;

public class Color {

	private int id;
	private String color;
	private float price;

	public Color(String color, float price) {

		this.color = color;
		this.price = price;
		this.id = new Random().nextInt();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return color + " (" + price +")";
	}
	
	
}
