package it.unical.cartest.model;

import java.util.HashMap;

public class Dealership {

	private HashMap<Integer, Car> cars;
	
	public Dealership() {

		this.cars = new HashMap<Integer, Car>();
		
		initCarsList();
	}
	
	private void initCarsList() {
		
		Car c1 = new Car("Seat", 11000.0f);
		Car c2 = new Car("Fiat", 12400.0f);
		Car c3 = new Car("Mazda", 15000.0f);
		
		this.cars.put(c1.getId(), c1);
		this.cars.put(c2.getId(), c2);
		this.cars.put(c3.getId(), c3);
	}

	public HashMap<Integer, Car> getCars() {
		return cars;
	}

	public void setCars(HashMap<Integer, Car> cars) {
		this.cars = cars;
	}
	
	
}
