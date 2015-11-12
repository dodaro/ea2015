package it.fmaida.model;

import java.util.ArrayList;

public class CarsList {

	private ArrayList<SimpleCar> cars;
	
	public CarsList() {
		// TODO Auto-generated constructor stub
	}
	
	public void setCars(ArrayList<SimpleCar> cars) {
		this.cars = cars;
	}
	
	public ArrayList<SimpleCar> getCars() {
		return cars;
	}
	
	public CarInterface findCarByName(String name) {
		for ( CarInterface car : cars ) {
			if ( car.getName().equals(name) ) {
				return car;
			}
		}
		return null;
	}
	
}
