package com.davide.app.model;

import java.util.ArrayList;

public class CarSeller {
	
	private ArrayList<Car> cars;
	private int idSelect;
	private int colorSelect;
	
	public CarSeller() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Car> getCars() {
		return cars;
	}

	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}

	public int getIdSelect() {
		return idSelect;
	}

	public void setIdSelect(int idSelect) {
		this.idSelect = idSelect;
	}

	public int getColorSelect() {
		return colorSelect;
	}

	public void setColorSelect(int colorSelect) {
		this.colorSelect = colorSelect;
	}

	
	
}
