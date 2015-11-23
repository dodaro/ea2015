package it.unical.carseller.model;

import java.util.HashMap;
import java.util.Map;

public class CarsChooser{

	private Map<Integer, Car> carMap = new HashMap<Integer, Car>();
	private Integer myCar;
	
	public Map<Integer, Car> getCarMap() {
		return carMap;
	}
	
	public void setCarMap(Map<Integer, Car> carMap) {
		this.carMap = carMap;
	}

	public Integer getMyCar() {
		return myCar;
	}

	public void setMyCar(Integer myCar) {
		this.myCar = myCar;
	}
	
	


}
