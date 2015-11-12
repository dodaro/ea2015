package com.davide.app.model;

import java.util.ArrayList;

public class Car {
	
	private String name;
	private ArrayList<String> availableColor;
	private int idColor;
	private double price;


	public Car() {
		// TODO Auto-generated constructor stub
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


	public ArrayList<String> getAvailableColor() {
		return availableColor;
	}


	public void setAvailableColor(ArrayList<String> availableColor) {
		this.availableColor = availableColor;
	}


	public int getIdColor() {
		return idColor;
	}


	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}
	
	
}
