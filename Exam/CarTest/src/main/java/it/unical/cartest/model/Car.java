package it.unical.cartest.model;

import java.util.Random;

public class Car {
	
	private int id;
	
	private String name;
	private float price;
	
	
	public Car(String name, float price) {

		this.name = name;
		this.price = price;
		
		this.id = new Random().nextInt();
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return name + " (" + price + " euro)";
	}
	
}
